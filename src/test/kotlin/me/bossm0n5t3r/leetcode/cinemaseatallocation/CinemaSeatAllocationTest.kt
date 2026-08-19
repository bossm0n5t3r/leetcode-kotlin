package me.bossm0n5t3r.leetcode.cinemaseatallocation

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CinemaSeatAllocationTest {
    private val sut = CinemaSeatAllocation.Solution()

    private data class TestData(val n: Int, val reservedSeats: Array<IntArray>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (n != other.n) return false
            if (result != other.result) return false
            if (!reservedSeats.contentDeepEquals(other.reservedSeats)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = n
            result1 = 31 * result1 + result
            result1 = 31 * result1 + reservedSeats.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(3, "[[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]".toArrayOfIntArray(), 4),
                TestData(2, "[[2,1],[1,8],[2,6]]".toArrayOfIntArray(), 2),
                TestData(4, "[[4,3],[1,4],[4,6],[1,7]]".toArrayOfIntArray(), 4),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.maxNumberOfFamilies(testData.n, testData.reservedSeats),
            )
        }
    }
}
