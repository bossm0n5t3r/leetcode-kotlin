package me.bossm0n5t3r.leetcode.primesubtractionoperation

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrimeSubtractionOperationTest {
    private val sut = PrimeSubtractionOperation.Solution()

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
                TestData("[4,9,6,10]".toIntArray(), true),
                TestData("[6,8,11,12]".toIntArray(), true),
                TestData("[5,8,3]".toIntArray(), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.primeSubOperation(testData.nums))
        }
    }
}
