package com.cmgcode.dailies

import com.cmgcode.dailies.WordFunnel1.getAllParentWords
import com.cmgcode.dailies.WordFunnel1.getBuildableWords
import com.cmgcode.dailies.WordFunnel1.isOneLetterRemoved
import com.cmgcode.dailies.WordFunnel1.getWordList
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

//Challenge - https://www.reddit.com/r/dailyprogrammer/comments/98ufvz/20180820_challenge_366_easy_word_funnel_1/

class WordFunnel1Test {

    @Test
    fun canRetrieveWordList(){
        val wordList = getWordList()
        assertTrue(wordList.isNotEmpty())
        assertTrue(wordList.containsAll(listOf("aa", "aah", "miscellaneousnesses")))
    }

    @Test
    fun canDetermineIfOneLetterDifferent(){
        assertTrue(isOneLetterRemoved("leave", "eave"))
        assertTrue(isOneLetterRemoved("reset", "rest"))
        assertTrue(isOneLetterRemoved("dragoon", "dragon"))
        assertFalse(isOneLetterRemoved("eave", "leave"))
        assertFalse(isOneLetterRemoved("sleet", "lets"))
        assertFalse(isOneLetterRemoved("skiff", "ski"))
    }

    @Test
    fun canGetBuildableWords(){
        assertTrue(getBuildableWords("dragoon").containsAll(listOf("dragon")))
        assertTrue(getBuildableWords("boats").containsAll(listOf("oats", "bats", "bots", "boas", "boat")))
        assertTrue(getBuildableWords("affidavit").isEmpty())

    }

    @Test(timeout = 5000)
    fun canDetermineAllParentWords(){
        assertEquals(getAllParentWords().size, 28)
    }

}
