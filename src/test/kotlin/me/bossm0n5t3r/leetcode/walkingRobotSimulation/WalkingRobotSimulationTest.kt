package me.bossm0n5t3r.leetcode.walkingRobotSimulation

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WalkingRobotSimulationTest {
    private val sut = WalkingRobotSimulation.Solution()

    private data class TestData(
        val commands: IntArray,
        val obstacles: Array<IntArray>,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!commands.contentEquals(other.commands)) return false
            if (!obstacles.contentDeepEquals(other.obstacles)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = commands.contentHashCode()
            result1 = 31 * result1 + obstacles.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(intArrayOf(4, -1, 3), emptyArray(), 25),
                TestData(intArrayOf(4, -1, 4, -2, 4), "[[2,4]]".toArrayOfIntArray(), 65),
                TestData(intArrayOf(6, -1, -1, 6), "[[0,0]]".toArrayOfIntArray(), 36),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.robotSim(test.commands, test.obstacles))
        }
    }
}
