package me.bossm0n5t3r.leetcode.firstcompletelypaintedroworcolumn

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstCompletelyPaintedRowOrColumnTest {
    private val sut = FirstCompletelyPaintedRowOrColumn.Solution()

    private data class TestData(val arr: IntArray, val mat: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!arr.contentEquals(other.arr)) return false
            if (!mat.contentDeepEquals(other.mat)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + arr.contentHashCode()
            result1 = 31 * result1 + mat.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,3,4,2]".toIntArray(), "[[1,4],[2,3]]".toArrayOfIntArray(), 2),
                TestData(
                    "[2,8,7,4,1,3,5,6,9]".toIntArray(),
                    "[[3,2,5],[1,4,6],[8,7,9]]".toArrayOfIntArray(),
                    3,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.firstCompleteIndex(testData.arr, testData.mat))
        }
    }
}
