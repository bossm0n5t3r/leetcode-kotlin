package me.bossm0n5t3r.leetcode.kRadiusSubarrayAverages

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class KRadiusSubarrayAveragesTest {
    private val kRadiusSubarrayAverages = KRadiusSubarrayAverages.Solution()

    private data class KRadiusSubarrayAveragesTestData(
        val nums: IntArray,
        val k: Int,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as KRadiusSubarrayAveragesTestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            return result.contentEquals(other.result)
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val examples =
            listOf(
                KRadiusSubarrayAveragesTestData(
                    intArrayOf(7, 4, 3, 9, 1, 8, 5, 2, 6),
                    3,
                    intArrayOf(-1, -1, -1, 5, 4, 4, -1, -1, -1),
                ),
                KRadiusSubarrayAveragesTestData(intArrayOf(100000), 0, intArrayOf(100000)),
                KRadiusSubarrayAveragesTestData(intArrayOf(8), 100000, intArrayOf(-1)),
            )
        examples.forEach { example ->
            assertThat(kRadiusSubarrayAverages.getAverages(example.nums, example.k))
                .isEqualTo(example.result)
        }
    }
}
