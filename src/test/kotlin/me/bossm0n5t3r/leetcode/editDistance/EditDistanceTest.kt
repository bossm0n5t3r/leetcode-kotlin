package me.bossm0n5t3r.leetcode.editDistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EditDistanceTest {
    private val sut = EditDistance.Solution()

    private data class TestData(val word1: String, val word2: String, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData("horse", "ros", 3), TestData("intention", "execution", 5))

        tests.forEach { test -> assertEquals(test.result, sut.minDistance(test.word1, test.word2)) }
    }
}
