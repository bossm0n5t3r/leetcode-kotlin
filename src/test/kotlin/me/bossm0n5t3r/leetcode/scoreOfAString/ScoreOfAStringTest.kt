package me.bossm0n5t3r.leetcode.scoreOfAString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ScoreOfAStringTest {
    private val sut = ScoreOfAString.Solution()

    private data class TestData(val s: String, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData("hello", 13), TestData("zaz", 50))

        tests.forEach { test -> assertEquals(test.result, sut.scoreOfString(test.s)) }
    }
}
