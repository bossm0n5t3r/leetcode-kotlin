package me.bossm0n5t3r.leetcode.validanagram

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidAnagramTest {
    private val validAnagram = ValidAnagram.Solution()

    data class ValidAnagramTestData(val s: String, val t: String, val result: Boolean)

    @Test
    fun isAnagram() {
        val tests =
            listOf(
                ValidAnagramTestData("anagram", "nagaram", true),
                ValidAnagramTestData("rat", "car", false),
            )
        tests.forEach { test -> assertEquals(test.result, validAnagram.isAnagram(test.s, test.t)) }
    }
}
