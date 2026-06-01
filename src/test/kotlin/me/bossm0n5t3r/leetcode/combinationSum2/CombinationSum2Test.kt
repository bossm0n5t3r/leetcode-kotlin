package me.bossm0n5t3r.leetcode.combinationSum2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CombinationSum2Test {
    private val sut = CombinationSum2.Solution()

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
    fun combinationSum2() {
        val tests =
            listOf(
                Example(
                    intArrayOf(10, 1, 2, 7, 6, 1, 5),
                    8,
                    listOf(listOf(1, 1, 6), listOf(1, 2, 5), listOf(1, 7), listOf(2, 6)),
                ),
                Example(intArrayOf(2, 5, 2, 1, 2), 5, listOf(listOf(1, 2, 2), listOf(5))),
            )
        tests.forEach { test ->
            assertThat(sut.combinationSum2(test.candidates, test.target))
                .containsExactlyInAnyOrderElementsOf(test.result)
        }
    }
}
