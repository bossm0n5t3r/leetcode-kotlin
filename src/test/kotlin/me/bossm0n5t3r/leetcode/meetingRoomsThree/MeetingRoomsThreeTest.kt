package me.bossm0n5t3r.leetcode.meetingRoomsThree

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MeetingRoomsThreeTest {
    private val sut = MeetingRoomsThree.Solution()

    private data class TestData(val n: Int, val meetings: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (!meetings.contentDeepEquals(other.meetings)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + meetings.contentDeepHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(2, "[[0,10],[1,5],[2,7],[3,4]]".toArrayOfIntArray(), 0),
                TestData(3, "[[1,20],[2,10],[3,5],[4,9],[6,8]]".toArrayOfIntArray(), 1),
                TestData(4, "[[18,19],[3,12],[17,19],[2,13],[7,10]]".toArrayOfIntArray(), 0),
                TestData(2, "[[0,10],[1,2],[12,14],[13,15]]".toArrayOfIntArray(), 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.mostBooked(test.n, test.meetings)) }
    }
}
