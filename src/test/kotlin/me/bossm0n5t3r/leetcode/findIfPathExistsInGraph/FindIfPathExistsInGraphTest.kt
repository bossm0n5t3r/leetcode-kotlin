package me.bossm0n5t3r.leetcode.findIfPathExistsInGraph

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindIfPathExistsInGraphTest {
    private val sut = FindIfPathExistsInGraph.Solution()

    private data class TestData(
        val n: Int,
        val edges: Array<IntArray>,
        val source: Int,
        val destination: Int,
        val result: Boolean,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!edges.contentDeepEquals(other.edges)) return false
            if (source != other.source) return false
            if (destination != other.destination) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result = n
            result = 31 * result + edges.contentDeepHashCode()
            result = 31 * result + source
            result = 31 * result + destination
            result = 31 * result + result.hashCode()
            return result
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(3, "[[0,1],[1,2],[2,0]]".toArrayOfIntArray(), 0, 2, true),
                TestData(6, "[[0,1],[0,2],[3,5],[5,4],[4,3]]".toArrayOfIntArray(), 0, 5, false),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.validPath(test.n, test.edges, test.source, test.destination),
            )
        }
    }
}
