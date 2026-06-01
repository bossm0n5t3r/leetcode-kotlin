package me.bossm0n5t3r.leetcode.checkIfEveryRowAndColumnContainsAllNumbers

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfEveryRowAndColumnContainsAllNumbersTest {
    private val sut = CheckIfEveryRowAndColumnContainsAllNumbers.Solution()

    private data class TestData(val matrix: Array<IntArray>, val result: Boolean) {
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
                TestData("[[1,2,3],[3,1,2],[2,3,1]]".toArrayOfIntArray(), true),
                TestData("[[1,1,1],[1,2,3],[1,2,3]]".toArrayOfIntArray(), false),
            )

        tests.forEach { test -> assertEquals(test.result, sut.checkValid(test.matrix)) }
    }
}
