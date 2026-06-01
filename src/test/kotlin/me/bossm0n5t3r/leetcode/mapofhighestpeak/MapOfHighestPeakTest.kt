package me.bossm0n5t3r.leetcode.mapofhighestpeak

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Test

class MapOfHighestPeakTest {
    private val sut = MapOfHighestPeak.Solution()

    private data class TestData(val isWater: Array<IntArray>, val result: Array<IntArray>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!isWater.contentDeepEquals(other.isWater)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = isWater.contentDeepHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[0,1],[0,0]]".toArrayOfIntArray(), "[[1,0],[2,1]]".toArrayOfIntArray()),
                TestData(
                    "[[0,0,1],[1,0,0],[0,0,0]]".toArrayOfIntArray(),
                    "[[1,1,0],[0,1,1],[1,2,2]]".toArrayOfIntArray(),
                ),
            )

        for (testData in testDataList) {
            testData.result.contentDeepEquals(sut.highestPeak(testData.isWater))
        }
    }
}
