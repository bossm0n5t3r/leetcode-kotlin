package me.bossm0n5t3r.leetcode.sortArrayByParity

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SortArrayByParityTest {
    private val sortArrayByParity = SortArrayByParity.Solution()

    private data class SortArrayByParityTestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as SortArrayByParityTestData

            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun sortArrayByParity() {
        val tests =
            listOf(
                SortArrayByParityTestData(intArrayOf(3, 1, 2, 4), intArrayOf(2, 4, 3, 1)),
                SortArrayByParityTestData(intArrayOf(0), intArrayOf(0)),
            )
        tests.forEach { test ->
            val result = sortArrayByParity.sortArrayByParity(test.nums)
            println(result.toList())
            assertTrue(result.contentEquals(test.result))

            val resultWithSwap = sortArrayByParity.sortArrayByParityWithSwap(test.nums)
            println(resultWithSwap.toList())
            assertTrue(resultWithSwap.contentEquals(test.result))
        }
    }
}
