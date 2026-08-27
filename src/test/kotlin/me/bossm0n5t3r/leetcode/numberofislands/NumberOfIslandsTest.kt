package me.bossm0n5t3r.leetcode.numberofislands

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfCharArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfIslandsTest {
    private val sut = NumberOfIslands.Solution()

    private data class TestData(val grid: Array<CharArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!grid.contentDeepEquals(other.grid)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = grid.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ("[[\"1\",\"1\",\"1\",\"1\",\"0\"]," +
                            "[\"1\",\"1\",\"0\",\"1\",\"0\"]," +
                            "[\"1\",\"1\",\"0\",\"0\",\"0\"]," +
                            "[\"0\",\"0\",\"0\",\"0\",\"0\"]]")
                        .toArrayOfCharArray(),
                    1,
                ),
                TestData(
                    ("[[\"1\",\"1\",\"0\",\"0\",\"0\"]," +
                            "[\"1\",\"1\",\"0\",\"0\",\"0\"]," +
                            "[\"0\",\"0\",\"1\",\"0\",\"0\"]," +
                            "[\"0\",\"0\",\"0\",\"1\",\"1\"]]")
                        .toArrayOfCharArray(),
                    3,
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.numIslands(test.grid)) }
    }
}
