package me.bossm0n5t3r.leetcode.findxvalueofarrayii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindXValueOfArrayIITest {
    private val sut = FindXValueOfArrayII.Solution()

    private class TestData(
        val nums: IntArray,
        val k: Int,
        val queries: Array<IntArray>,
        val result: IntArray,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    intArrayOf(1, 2, 3, 4, 5),
                    3,
                    "[[2,2,0,2],[3,3,3,0],[0,1,0,1]]".toArrayOfIntArray(),
                    intArrayOf(2, 2, 2),
                ),
                TestData(
                    intArrayOf(1, 2, 4, 8, 16, 32),
                    4,
                    "[[0,2,0,2],[0,2,0,1]]".toArrayOfIntArray(),
                    intArrayOf(1, 0),
                ),
                TestData(
                    intArrayOf(1, 1, 2, 1, 1),
                    2,
                    "[[2,1,0,1]]".toArrayOfIntArray(),
                    intArrayOf(5),
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.resultArray(testData.nums, testData.k, testData.queries).toList(),
            )
        }
    }
}
