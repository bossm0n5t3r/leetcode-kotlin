package me.bossm0n5t3r.leetcode.minimumcostofbuyingcandieswithdiscount

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumCostOfBuyingCandiesWithDiscountTest {
    private val sut = MinimumCostOfBuyingCandiesWithDiscount.Solution()

    private data class TestData(
        val cost: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!cost.contentEquals(other.cost)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + cost.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 3), 5),
                TestData(intArrayOf(6, 5, 7, 9, 2, 2), 23),
                TestData(intArrayOf(5, 5), 10),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.minimumCost(testData.cost),
            )
        }
    }
}
