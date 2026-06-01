package me.bossm0n5t3r.leetcode.findeventualsafestates

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindEventualSafeStatesTest {
    private val sut = FindEventualSafeStates.Solution()

    private data class TestData(val graph: Array<IntArray>, val result: List<Int>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!graph.contentDeepEquals(other.graph)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = graph.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[1,2],[2,3],[5],[0],[5],[],[]]".toArrayOfIntArray(), listOf(2, 4, 5, 6)),
                TestData("[[1,2,3,4],[1,2],[3,4],[0,4],[]]".toArrayOfIntArray(), listOf(4)),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.eventualSafeNodes(testData.graph))
        }
    }
}
