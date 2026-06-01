package me.bossm0n5t3r.leetcode.takegiftsfromtherichestpile

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TakeGiftsFromTheRichestPileTest {
    private val sut = TakeGiftsFromTheRichestPile.Solution()

    private data class TestData(val gifts: IntArray, val k: Int, val result: Long) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (result != other.result) return false
            if (!gifts.contentEquals(other.gifts)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + result.hashCode()
            result1 = 31 * result1 + gifts.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[25,64,9,4,100]".toIntArray(), 4, 29),
                TestData("[1,1,1,1]".toIntArray(), 4, 4),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.pickGifts(testData.gifts, testData.k))
        }
    }
}
