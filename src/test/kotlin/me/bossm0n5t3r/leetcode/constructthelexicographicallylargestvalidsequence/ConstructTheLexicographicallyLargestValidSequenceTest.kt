package me.bossm0n5t3r.leetcode.constructthelexicographicallylargestvalidsequence

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConstructTheLexicographicallyLargestValidSequenceTest {
    private val sut = ConstructTheLexicographicallyLargestValidSequence.Solution()

    private data class TestData(val n: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(3, "[3,1,2,3,2]".toIntArray()),
                TestData(5, "[5,3,1,4,3,5,2,4,2]".toIntArray()),
                TestData(4, "[4,2,3,2,4,3,1]".toIntArray()),
                TestData(7, "[7,5,3,6,4,3,5,7,4,6,2,1,2]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue { sut.constructDistancedSequence(testData.n).contentEquals(testData.result) }
        }
    }
}
