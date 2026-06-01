package me.bossm0n5t3r.leetcode.finduniquebinarystring

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindUniqueBinaryStringTest {
    private val sut = FindUniqueBinaryString.Solution()

    private data class TestData(val nums: Array<String>, val result: String) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[\"01\",\"10\"]".toArrayOfString(), "11"),
                TestData("[\"00\",\"01\"]".toArrayOfString(), "10"),
                TestData("[\"111\",\"011\",\"001\"]".toArrayOfString(), "000"),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.findDifferentBinaryString(testData.nums))
        }
    }
}
