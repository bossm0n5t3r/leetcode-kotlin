package me.bossm0n5t3r.leetcode.coinchange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CoinChangeTest {
    private val coinChange = CoinChange.Solution()

    private data class CoinChangeTestData(val coins: IntArray, val amount: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as CoinChangeTestData

            if (!coins.contentEquals(other.coins)) return false
            if (amount != other.amount) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = coins.contentHashCode()
            result1 = 31 * result1 + amount
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun coinChange() {
        val tests =
            listOf(
                CoinChangeTestData(intArrayOf(1, 2, 5), 11, 3),
                CoinChangeTestData(intArrayOf(2), 3, -1),
                CoinChangeTestData(intArrayOf(1), 0, 0),
                CoinChangeTestData(intArrayOf(2), 1, -1),
                CoinChangeTestData(intArrayOf(1, 2), 2, 1),
            )
        tests.forEach { test ->
            coinChange.coinChange(test.coins, test.amount).also { assertEquals(test.result, it) }
        }
    }
}
