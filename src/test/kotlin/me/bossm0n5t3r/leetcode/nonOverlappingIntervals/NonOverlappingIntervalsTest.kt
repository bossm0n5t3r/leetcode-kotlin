package me.bossm0n5t3r.leetcode.nonOverlappingIntervals

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NonOverlappingIntervalsTest {
    private val sut = NonOverlappingIntervals.Solution()

    private data class TestData(val intervals: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!intervals.contentDeepEquals(other.intervals)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = intervals.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[[1,2],[2,3],[3,4],[1,3]]".toArrayOfIntArray(), 1),
                TestData("[[1,2],[1,2],[1,2]]".toArrayOfIntArray(), 2),
                TestData("[[1,2],[2,3]]".toArrayOfIntArray(), 0),
            )

        tests.forEach { test ->
            assertEquals(test.result, sut.eraseOverlapIntervals(test.intervals))
        }
    }
}
