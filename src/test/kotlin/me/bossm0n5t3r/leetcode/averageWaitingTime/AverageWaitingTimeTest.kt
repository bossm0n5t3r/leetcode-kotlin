package me.bossm0n5t3r.leetcode.averageWaitingTime

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AverageWaitingTimeTest {
    private val sut = AverageWaitingTime.Solution()

    private data class TestData(val customers: Array<IntArray>, val result: Double) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!customers.contentDeepEquals(other.customers)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = customers.contentDeepHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[[1,2],[2,5],[4,3]]".toArrayOfIntArray(), 5.00000),
                TestData("[[5,2],[5,4],[10,3],[20,1]]".toArrayOfIntArray(), 3.25000),
            )

        tests.forEach { test -> assertEquals(test.result, sut.averageWaitingTime(test.customers)) }
    }
}
