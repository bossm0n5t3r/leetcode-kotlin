package me.bossm0n5t3r.leetcode.hindex

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HIndexTest {
    private val sut = HIndex.Solution()

    private data class TestData(val citations: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!citations.contentEquals(other.citations)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + citations.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("[3,0,6,1,5]".toIntArray(), 3), TestData("[1,3,1]".toIntArray(), 1))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.hIndex(testData.citations))
        }
    }
}
