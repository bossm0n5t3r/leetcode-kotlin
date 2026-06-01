package me.bossm0n5t3r.leetcode.threeSum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ThreeSumTest {
    private val threeSum = ThreeSum.Solution()

    data class ThreeSumTestData(val nums: IntArray, val result: List<List<Int>>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ThreeSumTestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun threeSum() {
        val tests =
            listOf(
                ThreeSumTestData(
                    intArrayOf(-1, 0, 1, 2, -1, -4),
                    listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)),
                ),
                ThreeSumTestData(intArrayOf(), listOf()),
                ThreeSumTestData(intArrayOf(0), listOf()),
            )
        tests.forEach { test ->
            assertThat(threeSum.threeSum(test.nums))
                .containsExactlyInAnyOrderElementsOf(test.result)
        }
    }
}
