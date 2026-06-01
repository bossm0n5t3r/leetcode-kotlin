package me.bossm0n5t3r.leetcode.nearestExitFromEntranceInMaze

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfCharArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NearestExitFromEntranceInMazeTest {
    private val sut = NearestExitFromEntranceInMaze.Solution()

    private data class TestData(
        val maze: Array<CharArray>,
        val entrance: IntArray,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!maze.contentDeepEquals(other.maze)) return false
            if (!entrance.contentEquals(other.entrance)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = maze.contentDeepHashCode()
            result1 = 31 * result1 + entrance.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    maze =
                        "[[\"+\",\"+\",\".\",\"+\"],[\".\",\".\",\".\",\"+\"],[\"+\",\"+\",\"+\",\".\"]]"
                            .toArrayOfCharArray(),
                    entrance = "[1,2]".toIntArray(),
                    result = 1,
                ),
                TestData(
                    maze =
                        "[[\"+\",\"+\",\"+\"],[\".\",\".\",\".\"],[\"+\",\"+\",\"+\"]]"
                            .toArrayOfCharArray(),
                    entrance = "[1,0]".toIntArray(),
                    result = 2,
                ),
                TestData(
                    maze = "[[\".\",\"+\"]]".toArrayOfCharArray(),
                    entrance = "[0,0]".toIntArray(),
                    result = -1,
                ),
                TestData(
                    maze =
                        "[[\"+\",\".\",\".\"],[\"+\",\".\",\"+\"],[\".\",\".\",\"+\"]]"
                            .toArrayOfCharArray(),
                    entrance = "[2,1]".toIntArray(),
                    result = 1,
                ),
            )

        tests.forEach { test ->
            test.maze.forEach { println(it.toList()) }
            assertEquals(sut.nearestExit(test.maze, test.entrance), test.result)
        }
    }
}
