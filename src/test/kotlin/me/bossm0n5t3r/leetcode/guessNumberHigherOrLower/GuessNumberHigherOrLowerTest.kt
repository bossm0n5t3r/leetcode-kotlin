package me.bossm0n5t3r.leetcode.guessNumberHigherOrLower

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessNumberHigherOrLowerTest {
    private val sut = GuessNumberHigherOrLower.Solution()

    private data class TestData(val n: Int, val pick: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(10, 6, 6),
                TestData(1, 1, 1),
                TestData(2, 1, 1),
                TestData(2126753390, 1702766719, 1702766719),
            )

        tests.forEach { test ->
            sut.init(test.n, test.pick)

            assertEquals(sut.guessNumber(test.n), test.result)
        }
    }
}
