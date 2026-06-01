package me.bossm0n5t3r.leetcode.largestLocalValuesInAMatrix

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LargestLocalValuesInAMatrixTest {
    private val sut = LargestLocalValuesInAMatrix.Solution()

    private data class TestData(val grid: Array<IntArray>, val result: Array<IntArray>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]".toArrayOfIntArray(),
                    "[[9,9],[8,6]]".toArrayOfIntArray(),
                ),
                TestData(
                    "[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]"
                        .toArrayOfIntArray(),
                    "[[2,2,2],[2,2,2],[2,2,2]]".toArrayOfIntArray(),
                ),
            )

        tests.forEach { test ->
            assertTrue { test.result.contentDeepEquals(sut.largestLocal(test.grid)) }
        }
    }
}
