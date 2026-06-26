package me.bossm0n5t3r.leetcode.countsubarrayswithmajorityelementii

import me.bossm0n5t3r.leetcode.countsubarrayswithmajorityelementi.CountSubarraysWithMajorityElementITest.TestData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSubarraysWithMajorityElementIITest {
    private val sut = CountSubarraysWithMajorityElementII.Solution()

    private data class TestData(val nums: IntArray, val target: Int, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (target != other.target) return false
            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = target
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(1, 2, 2, 3), 2, 5),
                TestData(intArrayOf(1, 1, 1, 1), 1, 10),
                TestData(intArrayOf(1, 2, 3), 4, 0),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.countMajoritySubarrays(testData.nums, testData.target),
            )
        }
    }
}
