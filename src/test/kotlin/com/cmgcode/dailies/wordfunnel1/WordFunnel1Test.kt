package com.cmgcode.dailies.wordfunnel1

import com.cmgcode.dailies.wordfunnel1.WordFunnel1.Companion.getWordList
import com.cmgcode.dailies.wordfunnel1.WordFunnel1.Companion.isOneLetterRemoved
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WordFunnel1Test {

    private val wordFunnel = WordFunnel1()

    @Test
    fun canRetrieveWordList(){
        val wordList = getWordList()
        assertTrue(wordList.isNotEmpty())
        assertTrue(wordList.containsAll(listOf("aa", "aah", "miscellaneousnesses")))
    }

    @Test // Funnel
    fun canDetermineIfOneLetterDifferent(){
        assertTrue(isOneLetterRemoved("leave", "eave"))
        assertTrue(isOneLetterRemoved("reset", "rest"))
        assertTrue(isOneLetterRemoved("dragoon", "dragon"))
        assertFalse(isOneLetterRemoved("eave", "leave"))
        assertFalse(isOneLetterRemoved("sleet", "lets"))
        assertFalse(isOneLetterRemoved("skiff", "ski"))
    }

    @Test // Bonus 1
    fun canGetBuildableWords(){
        assertTrue(wordFunnel.getBuildableWords("dragoon").containsAll(listOf("dragon")))
        assertTrue(wordFunnel.getBuildableWords("boats").containsAll(listOf("oats", "bats", "bots", "boas", "boat")))
        assertTrue(wordFunnel.getBuildableWords("affidavit").isEmpty())
    }

    @Test(timeout = 2000) // Bonus 2
    fun canDetermineAllParentWords(){
        assertEquals(wordFunnel.getWordsWithQuantityOfChildren(5).size, 28)
    }

}
