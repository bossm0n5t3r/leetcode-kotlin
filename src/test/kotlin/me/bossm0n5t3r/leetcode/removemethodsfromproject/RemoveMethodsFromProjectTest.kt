package me.bossm0n5t3r.leetcode.removemethodsfromproject

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveMethodsFromProjectTest {
    private val sut = RemoveMethodsFromProject.Solution()

    private data class TestData(
        val n: Int,
        val k: Int,
        val invocations: Array<IntArray>,
        val result: List<Int>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (k != other.k) return false
            if (!invocations.contentDeepEquals(other.invocations)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + k
            result1 = 31 * result1 + invocations.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(4, 1, "[[1,2],[0,1],[3,2]]".toArrayOfIntArray(), listOf(0, 1, 2, 3)),
                TestData(5, 0, "[[1,2],[0,2],[0,1],[3,4]]".toArrayOfIntArray(), listOf(3, 4)),
                TestData(3, 2, "[[1,2],[0,1],[2,0]]".toArrayOfIntArray(), emptyList()),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.remainingMethods(testData.n, testData.k, testData.invocations),
            )
        }
    }
}
