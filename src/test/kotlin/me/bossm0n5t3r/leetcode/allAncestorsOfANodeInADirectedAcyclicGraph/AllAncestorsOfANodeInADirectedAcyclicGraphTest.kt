package me.bossm0n5t3r.leetcode.allAncestorsOfANodeInADirectedAcyclicGraph

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AllAncestorsOfANodeInADirectedAcyclicGraphTest {
    private val sut = AllAncestorsOfANodeInADirectedAcyclicGraph.Solution()

    private data class TestData(
        val n: Int,
        val edges: Array<IntArray>,
        val result: List<List<Int>>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!edges.contentDeepEquals(other.edges)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + edges.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    8,
                    "[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]".toArrayOfIntArray(),
                    "[[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]".toListOfIntList(),
                ),
                TestData(
                    5,
                    "[[0,1],[0,2],[0,3],[0,4],[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]"
                        .toArrayOfIntArray(),
                    "[[],[0],[0,1],[0,1,2],[0,1,2,3]]".toListOfIntList(),
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.getAncestors(test.n, test.edges)) }
    }
}
