package me.bossm0n5t3r.leetcode.mostbeautifulitemforeachquery

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MostBeautifulItemForEachQueryTest {
    private val sut = MostBeautifulItemForEachQuery.Solution()

    private data class TestData(
        val items: Array<IntArray>,
        val queries: IntArray,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!items.contentDeepEquals(other.items)) return false
            if (!queries.contentEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = items.contentDeepHashCode()
            result1 = 31 * result1 + queries.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[1,2],[3,2],[2,4],[5,6],[3,5]]".toArrayOfIntArray(),
                    "[1,2,3,4,5,6]".toIntArray(),
                    "[2,4,5,5,6,6]".toIntArray(),
                ),
                TestData(
                    "[[1,2],[1,2],[1,3],[1,4]]".toArrayOfIntArray(),
                    "[1]".toIntArray(),
                    "[4]".toIntArray(),
                ),
                TestData("[[10,1000]]".toArrayOfIntArray(), "[5]".toIntArray(), "[0]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue {
                testData.result.contentEquals(sut.maximumBeauty(testData.items, testData.queries))
            }
        }
    }
}
