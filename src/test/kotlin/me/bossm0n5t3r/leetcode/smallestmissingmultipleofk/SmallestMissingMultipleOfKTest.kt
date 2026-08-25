package me.bossm0n5t3r.leetcode.smallestmissingmultipleofk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestMissingMultipleOfKTest {
    private val sut = SmallestMissingMultipleOfK.Solution()

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
                TestData(intArrayOf(8, 2, 3, 4, 6), 2, 10),
                TestData(intArrayOf(1, 4, 7, 10, 15), 5, 5),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.missingMultiple(testData.nums, testData.k))
        }
    }
}
