package me.bossm0n5t3r.leetcode.pathWithMaximumProbability

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathWithMaximumProbabilityTest {
    private val sut = PathWithMaximumProbability.Solution()

    private data class TestData(
        val n: Int,
        val edges: Array<IntArray>,
        val succProb: DoubleArray,
        val startNode: Int,
        val endNode: Int,
        val result: Double,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!edges.contentDeepEquals(other.edges)) return false
            if (!succProb.contentEquals(other.succProb)) return false
            if (startNode != other.startNode) return false
            if (endNode != other.endNode) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + edges.contentDeepHashCode()
            result1 = 31 * result1 + succProb.contentHashCode()
            result1 = 31 * result1 + startNode
            result1 = 31 * result1 + endNode
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    3,
                    "[[0,1],[1,2],[0,2]]".toArrayOfIntArray(),
                    doubleArrayOf(0.5, 0.5, 0.2),
                    0,
                    2,
                    0.25000,
                ),
                TestData(
                    3,
                    "[[0,1],[1,2],[0,2]]".toArrayOfIntArray(),
                    doubleArrayOf(0.5, 0.5, 0.3),
                    0,
                    2,
                    0.30000,
                ),
                TestData(3, "[[0,1]]".toArrayOfIntArray(), doubleArrayOf(0.5), 0, 2, 0.00000),
            )

        tests.forEach { test ->
            assertEquals(
                test.result,
                sut.maxProbability(test.n, test.edges, test.succProb, test.startNode, test.endNode),
            )
        }
    }
}
