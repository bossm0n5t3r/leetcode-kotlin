package me.bossm0n5t3r.leetcode.maximizeactivesectionwithtradeii

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeActiveSectionWithTradeIITest {
    private val sut = MaximizeActiveSectionWithTradeII.Solution()

    private data class TestData(
        val s: String,
        val queries: Array<IntArray>,
        val result: List<Int>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (s != other.s) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = s.hashCode()
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("01", "[[0,1]]".toArrayOfIntArray(), listOf(1)),
                TestData(
                    "0100",
                    "[[0,3],[0,2],[1,3],[2,3]]".toArrayOfIntArray(),
                    listOf(4, 3, 1, 1),
                ),
                TestData("1000100", "[[1,5],[0,6],[0,4]]".toArrayOfIntArray(), listOf(6, 7, 2)),
                TestData("01010", "[[0,3],[1,4],[1,3]]".toArrayOfIntArray(), listOf(4, 4, 2)),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.maxActiveSectionsAfterTrade(testData.s, testData.queries),
            )
        }
    }
}
