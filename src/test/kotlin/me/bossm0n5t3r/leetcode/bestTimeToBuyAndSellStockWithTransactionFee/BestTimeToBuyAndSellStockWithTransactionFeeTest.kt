package me.bossm0n5t3r.leetcode.bestTimeToBuyAndSellStockWithTransactionFee

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockWithTransactionFeeTest {
    private val sut = BestTimeToBuyAndSellStockWithTransactionFee.Solution()

    private data class TestData(val prices: IntArray, val fee: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!prices.contentEquals(other.prices)) return false
            if (fee != other.fee) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = prices.contentHashCode()
            result1 = 31 * result1 + fee
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[1,3,2,8,4,9]".toIntArray(), 2, 8),
                TestData("[1,3,7,5,10,3]".toIntArray(), 3, 6),
            )

        tests.forEach { test -> assertEquals(test.result, sut.maxProfit(test.prices, test.fee)) }
    }
}
