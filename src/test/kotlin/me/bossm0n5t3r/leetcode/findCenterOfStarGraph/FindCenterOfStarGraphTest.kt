package me.bossm0n5t3r.leetcode.findCenterOfStarGraph

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindCenterOfStarGraphTest {
    private val sut = FindCenterOfStarGraph.Solution()

    private data class TestData(val edges: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!edges.contentDeepEquals(other.edges)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = edges.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[[1,2],[2,3],[4,2]]".toArrayOfIntArray(), 2),
                TestData("[[1,2],[5,1],[1,3],[1,4]]".toArrayOfIntArray(), 1),
            )

        tests.forEach { test -> assertEquals(test.result, sut.findCenter(test.edges)) }
    }
}
