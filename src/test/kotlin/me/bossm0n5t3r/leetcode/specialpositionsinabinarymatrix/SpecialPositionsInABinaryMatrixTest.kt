package me.bossm0n5t3r.leetcode.specialpositionsinabinarymatrix

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpecialPositionsInABinaryMatrixTest {
    private val sut = SpecialPositionsInABinaryMatrix.Solution()

    private data class TestData(val mat: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!mat.contentDeepEquals(other.mat)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + mat.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[1,0,0],[0,0,1],[1,0,0]]".toArrayOfIntArray(), 1),
                TestData("[[1,0,0],[0,1,0],[0,0,1]]".toArrayOfIntArray(), 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numSpecial(testData.mat))
        }
    }
}
