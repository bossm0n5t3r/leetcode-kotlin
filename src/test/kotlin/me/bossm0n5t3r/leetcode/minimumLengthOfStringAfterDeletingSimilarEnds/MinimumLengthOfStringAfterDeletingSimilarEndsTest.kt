package me.bossm0n5t3r.leetcode.minimumLengthOfStringAfterDeletingSimilarEnds

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumLengthOfStringAfterDeletingSimilarEndsTest {
    private val sut = MinimumLengthOfStringAfterDeletingSimilarEnds.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData("ca", 2), TestData("cabaabac", 0), TestData("aabccabba", 3))

        tests.forEach { test -> assertEquals(test.result, sut.minimumLength(test.s)) }
    }
}
