package me.bossm0n5t3r.leetcode.rabbitsinforest

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RabbitsInForestTest {
    private val sut = RabbitsInForest.Solution()

    private data class TestData(val answers: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!answers.contentEquals(other.answers)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + answers.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(TestData("[1,1,2]".toIntArray(), 5), TestData("[10,10,10]".toIntArray(), 11))

        for (testData in testDataList) {
            assertEquals(testData.result, sut.numRabbits(testData.answers))
        }
    }
}
