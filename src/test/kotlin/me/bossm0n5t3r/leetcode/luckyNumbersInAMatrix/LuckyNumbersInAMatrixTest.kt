package me.bossm0n5t3r.leetcode.luckyNumbersInAMatrix

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LuckyNumbersInAMatrixTest {
    private val sut = LuckyNumbersInAMatrix.Solution()

    private data class TestData(val matrix: Array<IntArray>, val result: List<Int>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!matrix.contentDeepEquals(other.matrix)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = matrix.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[[3,7,8],[9,11,13],[15,16,17]]".toArrayOfIntArray(), listOf(15)),
                TestData("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]".toArrayOfIntArray(), listOf(12)),
                TestData("[[7,8],[1,2]]".toArrayOfIntArray(), listOf(7)),
            )

        tests.forEach { test -> assertEquals(test.result, sut.luckyNumbers(test.matrix)) }
    }
}
