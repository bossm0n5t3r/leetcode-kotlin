package me.bossm0n5t3r.leetcode.divideintervalsintominimumnumberofgroups

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DivideIntervalsIntoMinimumNumberOfGroupsTest {
    private val sut = DivideIntervalsIntoMinimumNumberOfGroups.Solution()

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
        val testDataList =
            listOf(
                TestData("[[5,10],[6,8],[1,5],[2,3],[1,10]]".toArrayOfIntArray(), 3),
                TestData("[[1,3],[5,6],[8,10],[11,13]]".toArrayOfIntArray(), 1),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minGroups(testData.intervals))
        }
    }
}
