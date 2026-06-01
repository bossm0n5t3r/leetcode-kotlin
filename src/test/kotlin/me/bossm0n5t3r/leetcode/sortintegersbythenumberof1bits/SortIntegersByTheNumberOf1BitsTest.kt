package me.bossm0n5t3r.leetcode.sortintegersbythenumberof1bits

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SortIntegersByTheNumberOf1BitsTest {
    private val sut = SortIntegersByTheNumberOf1Bits.Solution()

    private data class TestData(val arr: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr.contentEquals(other.arr)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[0,1,2,3,4,5,6,7,8]".toIntArray(), "[0,1,2,4,8,3,5,6,7]".toIntArray()),
                TestData(
                    "[1024,512,256,128,64,32,16,8,4,2,1]".toIntArray(),
                    "[1,2,4,8,16,32,64,128,256,512,1024]".toIntArray(),
                ),
            )

        for (testData in testDataList) {
            assertTrue { testData.result.contentEquals(sut.sortByBits(testData.arr)) }
        }
    }
}
