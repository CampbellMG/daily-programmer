package com.cmgcode.dailies

import java.net.URL
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.text.StringBuilder

//Challenge - https://www.reddit.com/r/dailyprogrammer/comments/98ufvz/20180820_challenge_366_easy_word_funnel_1/

object WordFunnel1 {
    private const val WORD_LIST_URL = "https://raw.githubusercontent.com/dolph/dictionary/master/enable1.txt"

    fun getWordList(): List<String> = Scanner(URL(WORD_LIST_URL).openStream(), StandardCharsets.UTF_8.toString())
            .use {
                it.useDelimiter("\\A")
                return if (it.hasNext()) it.next().split("\n") else emptyList()
            }

    fun isOneLetterRemoved(originalWordString: String, innerWord: String): Boolean {
        val originalWord = StringBuilder(originalWordString)

        for (i in 0 until originalWord.length) {
            val trimmedWord = StringBuilder(originalWord).deleteCharAt(i).toString()
            if (trimmedWord == innerWord) {
                return true
            }
        }

        return false
    }

    fun getBuildableWords(originalWord: String): List<String>{
        val innerWords = mutableListOf<String>()
        getWordList().forEach {
            if(isOneLetterRemoved(originalWord, it)){
                innerWords.add(it)
            }
        }
        return innerWords.distinct()
    }

    fun getAllParentWords(): List<String>{
        val wordList = getWordList()
        val parentWords = mutableListOf<String>()

        wordList.forEach { parentWord ->
            wordList.forEach {
                if(isOneLetterRemoved(parentWord, it)){
                    parentWords.add(parentWord)
                }
            }
        }

        return parentWords
    }
}
