package me.bossm0n5t3r.leetcode.rearrangeArrayElementsBySign

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RearrangeArrayElementsBySignTest {
    private val sut = RearrangeArrayElementsBySign.Solution()

    private data class TestData(val nums: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[3,1,-2,-5,2,-4]".toIntArray(), "[3,-2,1,-5,2,-4]".toIntArray()),
                TestData("[-1,1]".toIntArray(), "[1,-1]".toIntArray()),
            )

        tests.forEach { test -> assertThat(sut.rearrangeArray(test.nums)).isEqualTo(test.result) }
    }
}
