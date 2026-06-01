package me.bossm0n5t3r.leetcode.bitwisexorofallpairings

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BitwiseXOROfAllPairingsTest {
    private val sut = BitwiseXOROfAllPairings.Solution()

    private data class TestData(val nums1: IntArray, val nums2: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!nums1.contentEquals(other.nums1)) return false
            if (!nums2.contentEquals(other.nums2)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + nums1.contentHashCode()
            result1 = 31 * result1 + nums2.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[2,1,3]".toIntArray(), "[10,2,5,0]".toIntArray(), 13),
                TestData("[1,2]".toIntArray(), "[3,4]".toIntArray(), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.xorAllNums(testData.nums1, testData.nums2))
        }
    }
}
