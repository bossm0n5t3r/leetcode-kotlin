package me.bossm0n5t3r.leetcode.defusethebomb

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DefuseTheBombTest {
    private val sut = DefuseTheBomb.Solution()

    private data class TestData(val code: IntArray, val k: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (!code.contentEquals(other.code)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k
            result1 = 31 * result1 + code.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[5,7,1,4]".toIntArray(), 3, "[12,10,16,13]".toIntArray()),
                TestData("[1,2,3,4]".toIntArray(), 0, "[0,0,0,0]".toIntArray()),
                TestData("[2,4,9,3]".toIntArray(), -2, "[12,5,6,13]".toIntArray()),
            )

        for (testData in testDataList) {
            assertTrue { testData.result.contentEquals(sut.decrypt(testData.code, testData.k)) }
        }
    }
}
