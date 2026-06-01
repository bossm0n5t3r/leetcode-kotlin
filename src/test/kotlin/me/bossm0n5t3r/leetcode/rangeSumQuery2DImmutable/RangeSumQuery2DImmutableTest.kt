package me.bossm0n5t3r.leetcode.rangeSumQuery2DImmutable

import me.bossm0n5t3r.leetcode.utils.MatrixUtil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RangeSumQuery2DImmutableTest {
    private val matrixUtil = MatrixUtil()

    @Test
    fun test() {
        val rangeSumQuery2DImmutable =
            RangeSumQuery2DImmutable.NumMatrix(
                matrixUtil.generateMatrixFrom(
                    "[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]"
                )
            )

        assertThat(rangeSumQuery2DImmutable.sumRegion(2, 1, 4, 3)).isEqualTo(8)
        assertThat(rangeSumQuery2DImmutable.sumRegion(1, 1, 2, 2)).isEqualTo(11)
        assertThat(rangeSumQuery2DImmutable.sumRegion(1, 2, 2, 4)).isEqualTo(12)
    }
}
