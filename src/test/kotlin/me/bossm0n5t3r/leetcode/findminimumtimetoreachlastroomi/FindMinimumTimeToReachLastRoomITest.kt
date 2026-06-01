package me.bossm0n5t3r.leetcode.findminimumtimetoreachlastroomi

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumTimeToReachLastRoomITest {
    private val sut = FindMinimumTimeToReachLastRoomI.Solution()

    private data class TestData(val moveTime: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!moveTime.contentDeepEquals(other.moveTime)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result
            result1 = 31 * result1 + moveTime.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[[0,4],[4,4]]".toArrayOfIntArray(), 6),
                TestData("[[0,0,0],[0,0,0]]".toArrayOfIntArray(), 3),
                TestData("[[0,1],[1,2]]".toArrayOfIntArray(), 3),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.minTimeToReach(testData.moveTime))
        }
    }
}
