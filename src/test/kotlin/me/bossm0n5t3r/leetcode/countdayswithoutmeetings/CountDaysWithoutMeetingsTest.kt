package me.bossm0n5t3r.leetcode.countdayswithoutmeetings

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountDaysWithoutMeetingsTest {
    private val sut = CountDaysWithoutMeetings.Solution()

    private data class TestData(val days: Int, val meetings: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (days != other.days) return false
            if (result != other.result) return false
            if (!meetings.contentDeepEquals(other.meetings)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = days
            result1 = 31 * result1 + result
            result1 = 31 * result1 + meetings.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(10, "[[5,7],[1,3],[9,10]]".toArrayOfIntArray(), 2),
                TestData(5, "[[2,4],[1,3]]".toArrayOfIntArray(), 1),
                TestData(6, "[[1,6]]".toArrayOfIntArray(), 0),
                TestData(8, "[[3,4],[4,8],[2,5],[3,8]]".toArrayOfIntArray(), 1),
                TestData(
                    14,
                    "[[6,11],[7,13],[8,9],[5,8],[3,13],[11,13],[1,3],[5,10],[8,13],[3,9]]"
                        .toArrayOfIntArray(),
                    1,
                ),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.countDays(testData.days, testData.meetings))
        }
    }
}
