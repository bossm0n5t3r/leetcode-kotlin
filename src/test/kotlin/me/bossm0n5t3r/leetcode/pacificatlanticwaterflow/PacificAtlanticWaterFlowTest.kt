package me.bossm0n5t3r.leetcode.pacificatlanticwaterflow

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PacificAtlanticWaterFlowTest {
    private val sut = PacificAtlanticWaterFlow.Solution()

    private data class TestData(val heights: Array<IntArray>, val result: List<List<Int>>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!heights.contentDeepEquals(other.heights)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = heights.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]"
                        .toArrayOfIntArray(),
                    "[[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]".toListOfIntList(),
                ),
                TestData("[[1]]".toArrayOfIntArray(), "[[0,0]]".toListOfIntList()),
                TestData(
                    "[[2,1],[1,2]]".toArrayOfIntArray(),
                    "[[0,0],[0,1],[1,0],[1,1]]".toListOfIntList(),
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.pacificAtlantic(testData.heights))
        }
    }
}
