package me.bossm0n5t3r.leetcode.beautifulArrangement2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BeautifulArrangement2Test {
    private val beautifulArrangement2 = BeautifulArrangement2.Solution()

    private data class BeautifulArrangement2TestData(
        val n: Int,
        val k: Int,
        val result: List<IntArray>,
    )

    @Test
    fun constructArray() {
        val tests =
            listOf(
                BeautifulArrangement2TestData(3, 1, listOf(intArrayOf(1, 2, 3))),
                BeautifulArrangement2TestData(3, 2, listOf(intArrayOf(1, 3, 2))),
                BeautifulArrangement2TestData(
                    5,
                    2,
                    listOf(intArrayOf(1, 5, 4, 3, 2), intArrayOf(1, 2, 3, 5, 4)),
                ),
                BeautifulArrangement2TestData(
                    5,
                    3,
                    listOf(intArrayOf(1, 5, 2, 3, 4), intArrayOf(1, 2, 5, 3, 4)),
                ),
                BeautifulArrangement2TestData(5, 4, listOf(intArrayOf(1, 5, 2, 4, 3))),
                BeautifulArrangement2TestData(
                    6,
                    3,
                    listOf(intArrayOf(1, 6, 2, 3, 4, 5), intArrayOf(1, 2, 3, 6, 4, 5)),
                ),
            )
        tests.forEach { test ->
            beautifulArrangement2.constructArray(test.n, test.k).also {
                assertThat(test.result).contains(it)
            }

            beautifulArrangement2.constructArraySolution(test.n, test.k).also {
                assertThat(test.result).contains(it)
            }
        }
    }
}
