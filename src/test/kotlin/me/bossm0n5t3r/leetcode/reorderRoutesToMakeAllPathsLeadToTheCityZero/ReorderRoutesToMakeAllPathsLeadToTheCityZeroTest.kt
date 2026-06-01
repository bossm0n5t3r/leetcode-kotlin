package me.bossm0n5t3r.leetcode.reorderRoutesToMakeAllPathsLeadToTheCityZero

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest {
    private val sut = ReorderRoutesToMakeAllPathsLeadToTheCityZero.Solution()

    private data class TestData(val n: Int, val connections: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!connections.contentDeepEquals(other.connections)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + connections.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    n = 6,
                    connections = "[[0,1],[1,3],[2,3],[4,0],[4,5]]".toArrayOfIntArray(),
                    result = 3,
                ),
                TestData(
                    n = 5,
                    connections = "[[1,0],[1,2],[3,2],[3,4]]".toArrayOfIntArray(),
                    result = 2,
                ),
                TestData(n = 3, connections = "[[1,0],[2,0]]".toArrayOfIntArray(), result = 0),
            )

        tests.forEach { test ->
            assertEquals(sut.minReorder(test.n, test.connections), test.result)
        }
    }
}
