package me.bossm0n5t3r.leetcode.combinationSum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CombinationSumTest {
    private val sut = CombinationSum.Solution()

    private data class Example(
        val candidates: IntArray,
        val target: Int,
        val result: List<List<Int>>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Example

            if (!candidates.contentEquals(other.candidates)) return false
            if (target != other.target) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = candidates.contentHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun combinationSum() {
        val tests =
            listOf(
                Example(intArrayOf(2, 3, 6, 7), 7, listOf(listOf(2, 2, 3), listOf(7))),
                Example(
                    intArrayOf(2, 3, 5),
                    8,
                    listOf(listOf(2, 2, 2, 2), listOf(2, 3, 3), listOf(3, 5)),
                ),
            )
        tests.forEach { test ->
            assertThat(sut.combinationSum(test.candidates, test.target))
                .containsExactlyInAnyOrderElementsOf(test.result)
        }
    }
}
