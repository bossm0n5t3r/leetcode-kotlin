package me.bossm0n5t3r.leetcode.spiralMatrix2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpiralMatrix2Test {
    private val spiralMatrix2 = SpiralMatrix2.Solution()

    private data class SpiralMatrix2TestData(val n: Int, val result: Array<IntArray>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as SpiralMatrix2TestData

            if (n != other.n) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun generateMatrix() {
        val tests =
            listOf(
                SpiralMatrix2TestData(
                    3,
                    arrayOf(intArrayOf(1, 2, 3), intArrayOf(8, 9, 4), intArrayOf(7, 6, 5)),
                ),
                SpiralMatrix2TestData(1, arrayOf(intArrayOf(1))),
            )
        tests.forEach { test ->
            val result = spiralMatrix2.generateMatrix(test.n)
            result.forEach { println(it.toList()) }
            assertThat(result).isDeepEqualTo(test.result)
        }
    }
}
