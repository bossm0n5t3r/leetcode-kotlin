package me.bossm0n5t3r.leetcode.carfleet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarFleetTest {
    private val sut = CarFleet.Solution()

    private data class TestData(
        val target: Int,
        val position: IntArray,
        val speed: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (target != other.target) return false
            if (result != other.result) return false
            if (!position.contentEquals(other.position)) return false
            if (!speed.contentEquals(other.speed)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = target
            result1 = 31 * result1 + result
            result1 = 31 * result1 + position.contentHashCode()
            result1 = 31 * result1 + speed.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(12, intArrayOf(10, 8, 0, 5, 3), intArrayOf(2, 4, 1, 1, 3), 3),
                TestData(10, intArrayOf(3), intArrayOf(3), 1),
                TestData(100, intArrayOf(0, 2, 4), intArrayOf(4, 2, 1), 1),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.carFleet(testData.target, testData.position, testData.speed),
            )
        }
    }
}
