package me.bossm0n5t3r.leetcode.minimumIncrementToMakeArrayUnique

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumIncrementToMakeArrayUniqueTest {
    private val sut = MinimumIncrementToMakeArrayUnique.Solution()

    private data class TestData(val nums: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

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
    fun test() {
        val tests =
            listOf(TestData("[1,2,2]".toIntArray(), 1), TestData("[3,2,1,2,1,7]".toIntArray(), 6))

        tests.forEach { test -> assertEquals(test.result, sut.minIncrementForUnique(test.nums)) }
    }
}
