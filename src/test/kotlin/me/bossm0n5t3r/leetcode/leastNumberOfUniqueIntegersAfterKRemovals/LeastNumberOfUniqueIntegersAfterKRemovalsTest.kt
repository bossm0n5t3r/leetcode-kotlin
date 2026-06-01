package me.bossm0n5t3r.leetcode.leastNumberOfUniqueIntegersAfterKRemovals

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeastNumberOfUniqueIntegersAfterKRemovalsTest {
    private val sut = LeastNumberOfUniqueIntegersAfterKRemovals.Solution()

    private data class TestData(val arr: IntArray, val k: Int, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[5,5,4]".toIntArray(), 1, 1),
                TestData("[4,3,1,1,3,3,2]".toIntArray(), 3, 2),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.findLeastNumOfUniqueInts(test.arr, test.k))
        }
    }
}
