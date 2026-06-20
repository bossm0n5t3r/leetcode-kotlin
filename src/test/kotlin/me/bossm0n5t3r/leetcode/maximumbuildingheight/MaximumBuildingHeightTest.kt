package me.bossm0n5t3r.leetcode.maximumbuildingheight

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBuildingHeightTest {
    private val sut = MaximumBuildingHeight.Solution()

    private data class TestData(val n: Int, val restrictions: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (result != other.result) return false
            if (!restrictions.contentDeepEquals(other.restrictions)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result
            result1 = 31 * result1 + restrictions.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(5, "[[2,1],[4,1]]".toArrayOfIntArray(), 2),
                TestData(6, "[]".toArrayOfIntArray(), 5),
                TestData(10, "[[5,3],[2,5],[7,4],[10,3]]".toArrayOfIntArray(), 5),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.maxBuilding(testData.n, testData.restrictions))
        }
    }
}
