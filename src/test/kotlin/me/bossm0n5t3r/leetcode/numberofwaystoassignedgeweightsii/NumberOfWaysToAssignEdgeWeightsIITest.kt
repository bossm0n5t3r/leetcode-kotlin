package me.bossm0n5t3r.leetcode.numberofwaystoassignedgeweightsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToAssignEdgeWeightsIITest {
    private val sut = NumberOfWaysToAssignEdgeWeightsII.Solution()

    private data class TestData(
        val edges: Array<IntArray>,
        val queries: Array<IntArray>,
        val result: IntArray,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!edges.contentDeepEquals(other.edges)) return false
            if (!queries.contentDeepEquals(other.queries)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = edges.contentDeepHashCode()
            result1 = 31 * result1 + queries.contentDeepHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    arrayOf(intArrayOf(1, 2)),
                    arrayOf(intArrayOf(1, 1), intArrayOf(1, 2)),
                    intArrayOf(0, 1),
                ),
                TestData(
                    arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(3, 4), intArrayOf(3, 5)),
                    arrayOf(intArrayOf(1, 4), intArrayOf(3, 4), intArrayOf(2, 5)),
                    intArrayOf(2, 1, 4),
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.assignEdgeWeights(testData.edges, testData.queries).toList(),
            )
        }
    }
}
