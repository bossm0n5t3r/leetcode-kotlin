package me.bossm0n5t3r.leetcode.searchA2DMatrix2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SearchA2DMatrix2Test {
    private val searchA2DMatrix2 = SearchA2DMatrix2.Solution()

    private data class SearchA2DMatrix2TestData(
        val matrix: Array<IntArray>,
        val target: Int,
        val result: Boolean,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as SearchA2DMatrix2TestData

            if (!matrix.contentDeepEquals(other.matrix)) return false
            if (target != other.target) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = matrix.contentDeepHashCode()
            result1 = 31 * result1 + target
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun searchMatrix() {
        val tests =
            listOf(
                SearchA2DMatrix2TestData(
                    matrix =
                        arrayOf(
                            intArrayOf(1, 4, 7, 11, 15),
                            intArrayOf(2, 5, 8, 12, 19),
                            intArrayOf(3, 6, 9, 16, 22),
                            intArrayOf(10, 13, 14, 17, 24),
                            intArrayOf(18, 21, 23, 26, 30),
                        ),
                    target = 5,
                    result = true,
                ),
                SearchA2DMatrix2TestData(
                    matrix =
                        arrayOf(
                            intArrayOf(1, 4, 7, 11, 15),
                            intArrayOf(2, 5, 8, 12, 19),
                            intArrayOf(3, 6, 9, 16, 22),
                            intArrayOf(10, 13, 14, 17, 24),
                            intArrayOf(18, 21, 23, 26, 30),
                        ),
                    target = 20,
                    result = false,
                ),
                SearchA2DMatrix2TestData(
                    matrix = arrayOf(intArrayOf(-1, 3)),
                    target = 3,
                    result = true,
                ),
            )
        tests.forEach { test ->
            val result = searchA2DMatrix2.searchMatrix(test.matrix, test.target)
            println(result)
            assertEquals(result, test.result)

            val resultEfficient = searchA2DMatrix2.searchMatrixEfficient(test.matrix, test.target)
            println(resultEfficient)
            assertEquals(resultEfficient, test.result)
        }
    }
}
