package me.bossm0n5t3r.leetcode.findthemaximumnumberofelementsinsubset

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumNumberOfElementsInSubsetTest {
    private val sut = FindTheMaximumNumberOfElementsInSubset.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(5, 4, 1, 2, 2), 3),
                TestData(intArrayOf(1, 3, 2, 4), 1),
                TestData(intArrayOf(1, 1, 1, 1, 1), 5),
                TestData(intArrayOf(1, 1, 1, 1), 3),
                TestData(intArrayOf(2, 2, 4, 4, 16, 16, 256), 7),
                TestData(intArrayOf(1000000000, 1000000000), 1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maximumLength(testData.nums))
        }
    }
}
