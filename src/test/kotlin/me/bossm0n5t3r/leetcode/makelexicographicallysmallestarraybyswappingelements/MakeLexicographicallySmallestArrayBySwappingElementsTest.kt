package me.bossm0n5t3r.leetcode.makelexicographicallysmallestarraybyswappingelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MakeLexicographicallySmallestArrayBySwappingElementsTest {
    private val sut = MakeLexicographicallySmallestArrayBySwappingElements.Solution()

    private data class TestData(val nums: IntArray, val limit: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (limit != other.limit) return false
            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = limit
            result1 = 31 * result1 + nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 5, 3, 9, 8), 2, intArrayOf(1, 3, 5, 8, 9)),
                TestData(intArrayOf(1, 7, 6, 18, 2, 1), 3, intArrayOf(1, 6, 7, 18, 1, 2)),
                TestData(intArrayOf(1, 7, 28, 19, 10), 3, intArrayOf(1, 7, 28, 19, 10)),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.lexicographicallySmallestArray(testData.nums, testData.limit).toList(),
            )
        }
    }
}
