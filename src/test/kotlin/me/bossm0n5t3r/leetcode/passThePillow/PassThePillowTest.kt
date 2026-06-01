package me.bossm0n5t3r.leetcode.passThePillow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PassThePillowTest {
    private val sut = PassThePillow.Solution()

    private data class TestData(val n: Int, val time: Int, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(TestData(4, 5, 2), TestData(3, 2, 3), TestData(8, 9, 6), TestData(18, 38, 5))

        tests.forEach { test -> assertEquals(test.result, sut.passThePillow(test.n, test.time)) }
    }
}
