package me.bossm0n5t3r.leetcode.findtheprefixcommonarrayoftwoarrays

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Test

class FindThePrefixCommonArrayOfTwoArraysTest {
    private val sut = FindThePrefixCommonArrayOfTwoArrays.Solution()

    private data class TestData(val A: IntArray, val B: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!A.contentEquals(other.A)) return false
            if (!B.contentEquals(other.B)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = A.contentHashCode()
            result1 = 31 * result1 + B.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[1,3,2,4]".toIntArray(),
                    "[3,1,2,4]".toIntArray(),
                    "[0,2,3,4]".toIntArray(),
                ),
                TestData("[2,3,1]".toIntArray(), "[3,1,2]".toIntArray(), "[0,1,3]".toIntArray()),
            )

        for (testData in testDataList) {
            testData.result.contentEquals(sut.findThePrefixCommonArray(testData.A, testData.B))
        }
    }
}
