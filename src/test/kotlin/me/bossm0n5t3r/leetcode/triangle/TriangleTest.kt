package me.bossm0n5t3r.leetcode.triangle

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TriangleTest {
    private val sut = Triangle.Solution()

    private data class TriangleTestData(val triangle: List<List<Int>>, val result: Int)

    @Test
    fun minimumTotal() {
        val tests =
            listOf(
                TriangleTestData(
                    listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3)),
                    11,
                ),
                TriangleTestData(listOf(listOf(-10)), -10),
            )
        tests.forEach { test ->
            assertThat(test.result)
                .isEqualTo(sut.minimumTotal(test.triangle))
                .isEqualTo(sut.minimumTotalAt20250104(test.triangle))
        }
    }
}
