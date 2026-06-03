package me.bossm0n5t3r.leetcode.earliestfinishtimeforlandandwaterridesii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EarliestFinishTimeForLandAndWaterRidesIITest {
    private val sut = EarliestFinishTimeForLandAndWaterRidesII.Solution()

    private data class TestData(
        val landStartTime: IntArray,
        val landDuration: IntArray,
        val waterStartTime: IntArray,
        val waterDuration: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!landStartTime.contentEquals(other.landStartTime)) return false
            if (!landDuration.contentEquals(other.landDuration)) return false
            if (!waterStartTime.contentEquals(other.waterStartTime)) return false
            if (!waterDuration.contentEquals(other.waterDuration)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + landStartTime.contentHashCode()
            result1 = 31 * result1 + landDuration.contentHashCode()
            result1 = 31 * result1 + waterStartTime.contentHashCode()
            result1 = 31 * result1 + waterDuration.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(intArrayOf(2, 8), intArrayOf(4, 1), intArrayOf(6), intArrayOf(3), 9),
                TestData(intArrayOf(5), intArrayOf(3), intArrayOf(1), intArrayOf(10), 14),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.earliestFinishTime(
                    testData.landStartTime,
                    testData.landDuration,
                    testData.waterStartTime,
                    testData.waterDuration,
                ),
            )
        }
    }
}
