package me.bossm0n5t3r.leetcode.containerWithMostWater

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ContainerWithMostWaterTest {
    private val containerWithMostWater = ContainerWithMostWater.Solution()

    private data class ContainerWithMostWaterTestData(val height: IntArray, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ContainerWithMostWaterTestData

            if (!height.contentEquals(other.height)) return false
            return result == other.result
        }

        override fun hashCode(): Int {
            var result1 = height.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun maxArea() {
        val tests =
            listOf(
                ContainerWithMostWaterTestData(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7), 49),
                ContainerWithMostWaterTestData(intArrayOf(1, 1), 1),
                ContainerWithMostWaterTestData(intArrayOf(1, 2, 1), 2),
            )
        tests.forEach { test ->
            assertEquals(test.result, containerWithMostWater.maxArea(test.height))
            assertEquals(test.result, containerWithMostWater.maxAreaAt230709(test.height))
        }
    }
}
