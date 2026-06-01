package me.bossm0n5t3r.leetcode.candy

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CandyTest {
    private val sut = Candy.Solution()

    private data class TestData(val ratings: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!ratings.contentEquals(other.ratings)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + ratings.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("[1,0,2]".toIntArray(), 5), TestData("[1,2,2]".toIntArray(), 4))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.candy(testData.ratings))
        }
    }
}
