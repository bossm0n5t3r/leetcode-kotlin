package me.bossm0n5t3r.leetcode.greatestCommonDivisorOfStrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreatestCommonDivisorOfStringsTest {
    private val sut = GreatestCommonDivisorOfStrings.Solution()

    private data class TestData(val str1: String, val str2: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("ABCABC", "ABC", "ABC"),
                TestData("ABABAB", "ABAB", "AB"),
                TestData("LEET", "CODE", ""),
            )
        tests.forEach { test -> assertEquals(test.result, sut.gcdOfStrings(test.str1, test.str2)) }
    }
}
