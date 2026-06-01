package me.bossm0n5t3r.leetcode.checkifarrayissortedandrotated

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfArrayIsSortedAndRotatedTest {
    private val sut = CheckIfArrayIsSortedAndRotated.Solution()

    private data class TestData(val nums: IntArray, val result: Boolean) {
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
            listOf(
                TestData("[3,4,5,1,2]".toIntArray(), true),
                TestData("[2,1,3,4]".toIntArray(), false),
                TestData("[1,2,3]".toIntArray(), true),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.check(testData.nums))
        }
    }
}
