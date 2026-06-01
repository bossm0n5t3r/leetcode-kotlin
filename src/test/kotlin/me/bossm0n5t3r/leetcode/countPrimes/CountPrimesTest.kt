package me.bossm0n5t3r.leetcode.countPrimes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPrimesTest {
    private val countPrimes = CountPrimes.Solution()

    data class CountPrimesTestData(val n: Int, val result: Int)

    @Test
    fun countPrimes() {
        val tests =
            listOf(CountPrimesTestData(10, 4), CountPrimesTestData(0, 0), CountPrimesTestData(1, 0))
        tests.forEach { test -> assertEquals(countPrimes.countPrimes(test.n), test.result) }
    }
}
