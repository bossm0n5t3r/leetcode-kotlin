package me.bossm0n5t3r.leetcode.countnumberofbadpairs

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfBadPairsTest {
    private val sut = CountNumberOfBadPairs.Solution()

    private data class TestData(val nums: IntArray, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums.contentEquals(other.nums)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + nums.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("[4,1,3,3]".toIntArray(), 5), TestData("[1,2,3,4,5]".toIntArray(), 0))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countBadPairs(testData.nums))
        }
    }
}
