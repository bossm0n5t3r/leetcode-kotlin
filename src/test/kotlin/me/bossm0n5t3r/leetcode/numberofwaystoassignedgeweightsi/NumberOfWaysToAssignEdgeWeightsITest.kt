package me.bossm0n5t3r.leetcode.numberofwaystoassignedgeweightsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToAssignEdgeWeightsITest {
    private val sut = NumberOfWaysToAssignEdgeWeightsI.Solution()

    private data class TestData(val edges: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!edges.contentDeepEquals(other.edges)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + edges.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(arrayOf(intArrayOf(1, 2)), 1),
                TestData(
                    arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(3, 4), intArrayOf(3, 5)),
                    2,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.assignEdgeWeights(testData.edges))
        }
    }
}
