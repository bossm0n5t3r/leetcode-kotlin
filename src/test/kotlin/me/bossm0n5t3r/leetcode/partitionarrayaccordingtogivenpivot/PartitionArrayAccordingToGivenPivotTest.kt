package me.bossm0n5t3r.leetcode.partitionarrayaccordingtogivenpivot

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PartitionArrayAccordingToGivenPivotTest {
    private val sut = PartitionArrayAccordingToGivenPivot.Solution()

    private data class TestData(val nums: IntArray, val pivot: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (pivot != other.pivot) return false
            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = pivot
            result1 = 31 * result1 + nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[9,12,5,10,14,3,10]".toIntArray(),
                    10,
                    "[9,5,3,10,10,12,14]".toIntArray(),
                ),
                TestData("[-3,4,3,2]".toIntArray(), 2, "[-3,2,4,3]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentEquals(sut.pivotArray(testData.nums, testData.pivot))
            }
        }
    }
}
