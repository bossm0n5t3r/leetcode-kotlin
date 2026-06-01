package me.bossm0n5t3r.leetcode.subarraySumsDivisibleByK

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubarraySumsDivisibleByKTest {
    private val sut = SubarraySumsDivisibleByK.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[4,5,0,-2,-3,1]".toIntArray(), 5, 7),
                TestData("[5]".toIntArray(), 9, 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.subarraysDivByK(test.nums, test.k)) }
    }
}
