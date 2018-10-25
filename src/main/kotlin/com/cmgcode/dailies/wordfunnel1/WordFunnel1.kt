package com.cmgcode.dailies.wordfunnel1

import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.text.StringBuilder

class WordFunnel1 {

    private val wordList = getWordList()

    fun getBuildableWords(originalWord: String): List<String> {
        val innerWords = getInnerWords(originalWord)
        return wordList.filter { innerWords.contains(it) }
    }

    fun getWordsWithQuantityOfChildren(quantity: Int): List<String> = wordList.asSequence()
            .filter { word ->
                    getInnerWords(word)
                            .filter{wordList.contains(it)}.size == quantity
            }
            .toList()

    companion object {
        private const val WORD_LIST_URL = "https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt"

        fun getWordList(): Set<String> = Scanner(URL(WORD_LIST_URL).openStream(), StandardCharsets.UTF_8.toString())
                .use {
                    it.useDelimiter("\\A")
                    return if (it.hasNext()) it.next().split("\n").toSet() else emptySet()
                }

        fun isOneLetterRemoved(originalWordString: String, innerWord: String): Boolean =
                getInnerWords(originalWordString).contains(innerWord)

        private fun getInnerWords(originalWordString: String): Set<String> {
            val originalWord = StringBuilder(originalWordString)
            val innerWords = mutableSetOf<String>()

            for (i in 0 until originalWord.length) {
                val trimmedWord = StringBuilder(originalWord).deleteCharAt(i).toString()
                innerWords.add(trimmedWord)
            }

            return innerWords
        }
    }
}
