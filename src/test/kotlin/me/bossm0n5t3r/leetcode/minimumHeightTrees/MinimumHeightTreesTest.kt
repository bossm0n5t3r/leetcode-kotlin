package me.bossm0n5t3r.leetcode.minimumHeightTrees

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumHeightTreesTest {
    private val sut = MinimumHeightTrees.Solution()

    private data class TestData(val n: Int, val edges: Array<IntArray>, val result: List<Int>) {
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
                TestData(4, "[[1,0],[1,2],[1,3]]".toArrayOfIntArray(), listOf(1)),
                TestData(6, "[[3,0],[3,1],[3,2],[3,4],[5,4]]".toArrayOfIntArray(), listOf(3, 4)),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.findMinHeightTrees(test.n, test.edges))
        }
    }
}
