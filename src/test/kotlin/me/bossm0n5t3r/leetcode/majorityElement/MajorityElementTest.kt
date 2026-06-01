package me.bossm0n5t3r.leetcode.majorityElement

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {
    private val majorityElement = MajorityElement.Solution()

    data class MajorityElementTestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as MajorityElementTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun majorityElement() {
        val tests =
            listOf(
                MajorityElementTestData(intArrayOf(3, 2, 3), 3),
                MajorityElementTestData(intArrayOf(2, 2, 1, 1, 1, 2, 2), 2),
                MajorityElementTestData(intArrayOf(1), 1),
                MajorityElementTestData(intArrayOf(2, 2), 2),
                MajorityElementTestData(intArrayOf(6, 5, 5), 5),
            )
        tests.forEach { test ->
            assertEquals(majorityElement.majorityElement(test.nums), test.result)
        }
    }
}
