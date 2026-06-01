package me.bossm0n5t3r.leetcode.trionicarrayi

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrionicArrayITest {
    private val sut = TrionicArrayI.Solution()

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
                TestData("[1,3,5,4,2,6]".toIntArray(), true),
                TestData("[2,1,3]".toIntArray(), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.isTrionic(testData.nums))
        }
    }
}
