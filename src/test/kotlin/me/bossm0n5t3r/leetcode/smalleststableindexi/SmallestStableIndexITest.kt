package me.bossm0n5t3r.leetcode.smalleststableindexi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestStableIndexITest {
    private val sut = SmallestStableIndexI.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + result
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(5, 0, 1, 4), 3, 3),
                TestData(intArrayOf(3, 2, 1), 1, -1),
                TestData(intArrayOf(0), 0, 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.firstStableIndex(testData.nums, testData.k))
        }
    }
}
