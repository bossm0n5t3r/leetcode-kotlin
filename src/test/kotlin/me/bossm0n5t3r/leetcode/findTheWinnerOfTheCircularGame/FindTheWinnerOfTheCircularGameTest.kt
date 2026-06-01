package me.bossm0n5t3r.leetcode.findTheWinnerOfTheCircularGame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheWinnerOfTheCircularGameTest {
    private val sut = FindTheWinnerOfTheCircularGame.Solution()

    private data class TestData(val n: Int, val k: Int, val result: Int)

    @Test
    fun test() {
        val tests = listOf(TestData(5, 2, 3), TestData(6, 5, 1))

        tests.forEach { test -> assertEquals(test.result, sut.findTheWinner(test.n, test.k)) }
    }
}
