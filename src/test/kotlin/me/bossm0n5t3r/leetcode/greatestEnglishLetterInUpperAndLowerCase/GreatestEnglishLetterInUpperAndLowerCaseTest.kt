package me.bossm0n5t3r.leetcode.greatestEnglishLetterInUpperAndLowerCase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreatestEnglishLetterInUpperAndLowerCaseTest {
    private val sut = GreatestEnglishLetterInUpperAndLowerCase.Solution()

    private data class TestData(val s: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("lEeTcOdE", "E"),
                TestData("arRAzFif", "R"),
                TestData("AbCdEfGhIjK", ""),
            )

        tests.forEach { test -> assertEquals(test.result, sut.greatestLetter(test.s)) }
    }
}
