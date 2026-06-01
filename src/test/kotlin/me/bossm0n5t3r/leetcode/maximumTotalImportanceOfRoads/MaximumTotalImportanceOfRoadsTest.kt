package me.bossm0n5t3r.leetcode.maximumTotalImportanceOfRoads

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalImportanceOfRoadsTest {
    private val sut = MaximumTotalImportanceOfRoads.Solution()

    private data class TestData(val n: Int, val roads: Array<IntArray>, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!roads.contentDeepEquals(other.roads)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + roads.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(5, "[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]".toArrayOfIntArray(), 43),
                TestData(5, "[[0,3],[2,4],[1,3]]".toArrayOfIntArray(), 20),
                TestData(5, "[[0,1]]".toArrayOfIntArray(), 9),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.maximumImportance(test.n, test.roads))
        }
    }
}
