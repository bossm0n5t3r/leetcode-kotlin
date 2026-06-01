package me.bossm0n5t3r.leetcode.findTheTownJudge

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheTownJudgeTest {
    private val sut = FindTheTownJudge.Solution()

    private data class TestData(val n: Int, val trust: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!trust.contentDeepEquals(other.trust)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + trust.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(2, "[[1,2]]".toArrayOfIntArray(), 2),
                TestData(3, "[[1,3],[2,3]]".toArrayOfIntArray(), 3),
                TestData(3, "[[1,3],[2,3],[3,1]]".toArrayOfIntArray(), -1),
            )

        tests.forEach { test -> assertEquals(test.result, sut.findJudge(test.n, test.trust)) }
    }
}
