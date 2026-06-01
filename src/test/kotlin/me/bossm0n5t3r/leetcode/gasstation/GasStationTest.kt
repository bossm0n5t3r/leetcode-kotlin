package me.bossm0n5t3r.leetcode.gasstation

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GasStationTest {
    private val sut = GasStation.Solution()

    private data class TestData(val gas: IntArray, val cost: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!gas.contentEquals(other.gas)) return false
            if (!cost.contentEquals(other.cost)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + gas.contentHashCode()
            result1 = 31 * result1 + cost.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[1,2,3,4,5]".toIntArray(), "[3,4,5,1,2]".toIntArray(), 3),
                TestData("[2,3,4]".toIntArray(), "[3,4,3]".toIntArray(), -1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.canCompleteCircuit(testData.gas, testData.cost))
        }
    }
}
