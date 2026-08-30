package me.bossm0n5t3r.leetcode.removingminimumandmaximumfromarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemovingMinimumAndMaximumFromArrayTest {
    private val sut = RemovingMinimumAndMaximumFromArray.Solution()

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
                TestData(intArrayOf(2, 10, 7, 5, 4, 1, 8, 6), 5),
                TestData(intArrayOf(0, -4, 19, 1, 8, -2, -3, 5), 3),
                TestData(intArrayOf(101), 1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minimumDeletions(testData.nums))
        }
    }
}
