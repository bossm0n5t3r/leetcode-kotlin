package me.bossm0n5t3r.leetcode.imageoverlap

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ImageOverlapTest {
    private val sut = ImageOverlap.Solution()

    private class TestData(val img1: Array<IntArray>, val img2: Array<IntArray>, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,1,0],[0,1,0],[0,1,0]]".toArrayOfIntArray(),
                    "[[0,0,0],[0,1,1],[0,0,1]]".toArrayOfIntArray(),
                    3,
                ),
                TestData("[[1]]".toArrayOfIntArray(), "[[1]]".toArrayOfIntArray(), 1),
                TestData("[[0]]".toArrayOfIntArray(), "[[0]]".toArrayOfIntArray(), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.largestOverlap(testData.img1, testData.img2))
        }
    }
}
