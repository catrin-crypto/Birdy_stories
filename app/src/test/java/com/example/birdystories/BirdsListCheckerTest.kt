package com.example.birdystories

import com.example.birdystories.data.bird.datasource.WikiBirdsDataSourceImpl
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class BirdsListCheckerTest {
    @Test
    fun birdsListChecker_containsNoRussianLetters_ReturnsTrue(){
        assertTrue(WikiBirdsDataSourceImpl.birdsListChecker("Русские буквы"))
    }
    @Test
    fun birdsListChecker_containsPrefix_ReturnsFalse(){
        assertFalse(WikiBirdsDataSourceImpl.birdsListChecker("Список"))
    }
    @Test
    fun birdsListChecker_containsChars_ReturnsTrue(){
        assertTrue(WikiBirdsDataSourceImpl.birdsListChecker(":,"))
    }
}