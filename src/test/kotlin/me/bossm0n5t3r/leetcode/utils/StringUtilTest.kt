package me.bossm0n5t3r.leetcode.utils

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringUtilTest {
    @Test
    fun toArrayOfIntArrayTest() {
        assertThat("[]".toArrayOfIntArray()).isEqualTo(emptyArray<IntArray>())

        assertThat("[[3,2,1],[1,7,6],[2,7,7]]".toArrayOfIntArray())
            .isEqualTo(arrayOf(intArrayOf(3, 2, 1), intArrayOf(1, 7, 6), intArrayOf(2, 7, 7)))

        assertThat("[[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]".toArrayOfIntArray())
            .isEqualTo(
                arrayOf(
                    intArrayOf(3, 1, 2, 2),
                    intArrayOf(1, 4, 4, 5),
                    intArrayOf(2, 4, 2, 2),
                    intArrayOf(2, 4, 2, 2),
                )
            )

        assertThat("[[1,2],[2,3],[5],[0],[5],[],[]]".toArrayOfIntArray())
            .isEqualTo(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(5),
                    intArrayOf(0),
                    intArrayOf(5),
                    intArrayOf(),
                    intArrayOf(),
                )
            )

        assertThat("[[1,2,3,4],[1,2],[3,4],[0,4],[]]".toArrayOfIntArray())
            .isEqualTo(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(0, 4),
                    intArrayOf(),
                )
            )
    }
}
