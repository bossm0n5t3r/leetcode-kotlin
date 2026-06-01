package me.bossm0n5t3r.leetcode.fourSum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FourSumTest {
    private val fourSum = FourSum.Solution()

    private data class FourSumTestData(
        val nums: IntArray,
        val target: Int,
        val result: List<List<Int>>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as FourSumTestData

            if (!nums.contentEquals(other.nums)) return false
            if (target != other.target) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun fourSum() {
        val tests =
            listOf(
                FourSumTestData(
                    intArrayOf(1, 0, -1, 0, -2, 2),
                    0,
                    listOf(listOf(-2, -1, 1, 2), listOf(-2, 0, 0, 2), listOf(-1, 0, 0, 1)),
                ),
                FourSumTestData(intArrayOf(2, 2, 2, 2, 2), 8, listOf(listOf(2, 2, 2, 2))),
            )
        tests.forEach { test ->
            val result = fourSum.fourSum(test.nums, test.target)
            println(result)
            assertThat(result).containsExactlyInAnyOrderElementsOf(test.result)
        }
    }
}
