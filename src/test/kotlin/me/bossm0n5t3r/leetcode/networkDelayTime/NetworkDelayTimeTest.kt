package me.bossm0n5t3r.leetcode.networkDelayTime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class NetworkDelayTimeTest {
    private val networkDelayTime = NetworkDelayTime.Solution()

    private data class NetworkDelayTimeTestData(
        val times: Array<IntArray>,
        val n: Int,
        val k: Int,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as NetworkDelayTimeTestData

            if (!times.contentDeepEquals(other.times)) return false
            if (n != other.n) return false
            if (k != other.k) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = times.contentDeepHashCode()
            result1 = 31 * result1 + n
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun networkDelayTime() {
        val tests =
            listOf(
                NetworkDelayTimeTestData(
                    arrayOf(intArrayOf(2, 1, 1), intArrayOf(2, 3, 1), intArrayOf(3, 4, 1)),
                    4,
                    2,
                    2,
                ),
                NetworkDelayTimeTestData(arrayOf(intArrayOf(1, 2, 1)), 2, 1, 1),
                NetworkDelayTimeTestData(arrayOf(intArrayOf(1, 2, 1)), 2, 2, -1),
                NetworkDelayTimeTestData(
                    arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 1, 3)),
                    2,
                    2,
                    3,
                ),
                NetworkDelayTimeTestData(
                    arrayOf(intArrayOf(1, 2, 1), intArrayOf(2, 3, 2), intArrayOf(1, 3, 4)),
                    3,
                    1,
                    3,
                ),
            )
        tests.forEach { test ->
            val result = networkDelayTime.networkDelayTime(test.times, test.n, test.k)
            assertEquals(test.result, result)
        }
    }
}
