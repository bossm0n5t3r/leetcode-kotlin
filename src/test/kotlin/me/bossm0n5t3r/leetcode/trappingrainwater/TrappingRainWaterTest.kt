package me.bossm0n5t3r.leetcode.trappingrainwater

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrappingRainWaterTest {
    private val sut = TrappingRainWater.Solution()

    private data class TestData(val height: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!height.contentEquals(other.height)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + height.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[0,1,0,2,1,0,1,3,2,1,2,1]".toIntArray(), 6),
                TestData("[4,2,0,3,2,5]".toIntArray(), 9),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.trap(testData.height))
        }
    }
}
