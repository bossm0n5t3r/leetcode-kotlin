package me.bossm0n5t3r.leetcode.checkifgridcanbecutintosections

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfGridCanBeCutIntoSectionsTest {
    private val sut = CheckIfGridCanBeCutIntoSections.Solution()

    private data class TestData(val n: Int, val rectangles: Array<IntArray>, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (result != other.result) return false
            if (!rectangles.contentDeepEquals(other.rectangles)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + rectangles.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(5, "[[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]".toArrayOfIntArray(), true),
                TestData(4, "[[0,0,1,1],[2,0,3,4],[0,2,2,3],[3,0,4,3]]".toArrayOfIntArray(), true),
                TestData(
                    4,
                    "[[0,2,2,4],[1,0,3,2],[2,2,3,4],[3,0,4,2],[3,2,4,4]]".toArrayOfIntArray(),
                    false,
                ),
                TestData(4, "[[0,0,1,4],[1,0,2,4],[2,0,3,4],[3,0,4,4]]".toArrayOfIntArray(), true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.checkValidCuts(testData.n, testData.rectangles))
        }
    }
}
