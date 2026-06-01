package me.bossm0n5t3r.leetcode.countsquaresubmatriceswithallones

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountSquareSubmatricesWithAllOnesTest {
    private val sut = CountSquareSubmatricesWithAllOnes.Solution()

    private data class TestData(val matrix: Array<IntArray>, val result: Int) {
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
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[0,1,1,1],[1,1,1,1],[0,1,1,1]]".toArrayOfIntArray(), 15),
                TestData("[[1,0,1],[1,1,0],[1,1,0]]".toArrayOfIntArray(), 7),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countSquares(testData.matrix))
        }
    }
}
