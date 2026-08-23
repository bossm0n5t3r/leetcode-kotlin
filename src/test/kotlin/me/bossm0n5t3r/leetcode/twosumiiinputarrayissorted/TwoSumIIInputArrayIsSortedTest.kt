package me.bossm0n5t3r.leetcode.twosumiiinputarrayissorted

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoSumIIInputArrayIsSortedTest {
    private val sut = TwoSumIIInputArrayIsSorted.Solution()

    private data class TestData(val numbers: IntArray, val target: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (target != other.target) return false
            if (!numbers.contentEquals(other.numbers)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = target
            result1 = 31 * result1 + numbers.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[2,7,11,15]".toIntArray(), 9, "[1,2]".toIntArray()),
                TestData("[2,3,4]".toIntArray(), 6, "[1,3]".toIntArray()),
                TestData("[-1,0]".toIntArray(), -1, "[1,2]".toIntArray()),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result.toList(),
                sut.twoSum(testData.numbers, testData.target).toList(),
            )
        }
    }
}
