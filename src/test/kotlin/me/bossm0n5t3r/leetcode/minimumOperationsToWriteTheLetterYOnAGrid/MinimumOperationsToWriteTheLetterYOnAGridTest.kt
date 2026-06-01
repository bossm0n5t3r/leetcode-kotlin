package me.bossm0n5t3r.leetcode.minimumOperationsToWriteTheLetterYOnAGrid

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToWriteTheLetterYOnAGridTest {
    private val sut = MinimumOperationsToWriteTheLetterYOnAGrid.Solution()

    private data class TestData(val grid: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[[1,2,2],[1,1,0],[0,1,0]]".toArrayOfIntArray(), 3),
                TestData(
                    "[[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]"
                        .toArrayOfIntArray(),
                    12,
                ),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.minimumOperationsToWriteY(test.grid))
        }
    }
}
