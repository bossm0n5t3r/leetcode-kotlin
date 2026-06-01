package me.bossm0n5t3r.leetcode.minimumNumberOfArrowsToBurstBalloons

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfArrowsToBurstBalloonsTest {
    private val sut = MinimumNumberOfArrowsToBurstBalloons.Solution()

    private data class TestData(val points: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!points.contentDeepEquals(other.points)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = points.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[[10,16],[2,8],[1,6],[7,12]]".toArrayOfIntArray(), 2),
                TestData("[[1,2],[3,4],[5,6],[7,8]]".toArrayOfIntArray(), 4),
                TestData("[[1,2],[2,3],[3,4],[4,5]]".toArrayOfIntArray(), 2),
            )

        tests.forEach { test -> assertEquals(test.result, sut.findMinArrowShots(test.points)) }
    }
}
