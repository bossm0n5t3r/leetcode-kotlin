package me.bossm0n5t3r.leetcode.furthestBuildingYouCanReach

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FurthestBuildingYouCanReachTest {
    private val sut = FurthestBuildingYouCanReach.Solution()

    private data class TestData(
        val heights: IntArray,
        val bricks: Int,
        val ladders: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!heights.contentEquals(other.heights)) return false
            if (bricks != other.bricks) return false
            if (ladders != other.ladders) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = heights.contentHashCode()
            result1 = 31 * result1 + bricks
            result1 = 31 * result1 + ladders
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[4,2,7,6,9,14,12]".toIntArray(), 5, 1, 4),
                TestData("[4,12,2,7,3,18,20,3,19]".toIntArray(), 10, 2, 7),
                TestData("[14,3,19,3]".toIntArray(), 17, 0, 3),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.furthestBuilding(test.heights, test.bricks, test.ladders))
        }
    }
}
