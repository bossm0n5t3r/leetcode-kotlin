package me.bossm0n5t3r.leetcode.specialarrayi

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpecialArrayITest {
    private val sut = SpecialArrayI.Solution()

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
                TestData("[1]".toIntArray(), true),
                TestData("[2,1,4]".toIntArray(), true),
                TestData("[4,3,1,6]".toIntArray(), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.isArraySpecial(testData.nums))
        }
    }
}
