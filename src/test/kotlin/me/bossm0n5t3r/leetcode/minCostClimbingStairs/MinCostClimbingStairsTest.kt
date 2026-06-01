package me.bossm0n5t3r.leetcode.minCostClimbingStairs

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinCostClimbingStairsTest {
    private val sut = MinCostClimbingStairs.Solution()

    private data class TestData(val cost: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!cost.contentEquals(other.cost)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = cost.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(cost = "[10,15,20]".toIntArray(), result = 15),
                TestData(cost = "[1,100,1,1,1,100,1,1,100,1]".toIntArray(), result = 6),
            )

        tests.forEach { test -> assertEquals(sut.minCostClimbingStairs(test.cost), test.result) }
    }
}
