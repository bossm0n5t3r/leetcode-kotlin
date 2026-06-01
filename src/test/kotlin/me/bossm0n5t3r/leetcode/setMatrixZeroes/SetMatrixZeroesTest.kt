package me.bossm0n5t3r.leetcode.setMatrixZeroes

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SetMatrixZeroesTest {
    private val sut = SetMatrixZeroes.Solution()

    private data class TestData(val matrix: Array<IntArray>, val result: Array<IntArray>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!matrix.contentDeepEquals(other.matrix)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = matrix.contentDeepHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "[[1,1,1],[1,0,1],[1,1,1]]".toArrayOfIntArray(),
                    "[[1,0,1],[0,0,0],[1,0,1]]".toArrayOfIntArray(),
                ),
                TestData(
                    "[[0,1,2,0],[3,4,5,2],[1,3,1,5]]".toArrayOfIntArray(),
                    "[[0,0,0,0],[0,4,5,0],[0,3,1,0]]".toArrayOfIntArray(),
                ),
            )

        tests.forEach { test ->
            sut.setZeroes(test.matrix)
            assertThat(test.matrix).isDeepEqualTo(test.result)
        }
    }
}
