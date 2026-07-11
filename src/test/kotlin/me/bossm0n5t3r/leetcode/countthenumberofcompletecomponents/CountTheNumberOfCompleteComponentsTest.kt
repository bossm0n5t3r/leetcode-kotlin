package me.bossm0n5t3r.leetcode.countthenumberofcompletecomponents

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTheNumberOfCompleteComponentsTest {
    private val sut = CountTheNumberOfCompleteComponents.Solution()

    private data class TestData(val n: Int, val edges: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (result != other.result) return false
            if (!edges.contentDeepEquals(other.edges)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result
            result1 = 31 * result1 + edges.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(6, "[[0,1],[0,2],[1,2],[3,4]]".toArrayOfIntArray(), 3),
                TestData(6, "[[0,1],[0,2],[1,2],[3,4],[3,5]]".toArrayOfIntArray(), 1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countCompleteComponents(testData.n, testData.edges))
        }
    }
}
