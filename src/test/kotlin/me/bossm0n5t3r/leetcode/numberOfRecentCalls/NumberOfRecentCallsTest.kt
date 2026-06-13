package me.bossm0n5t3r.leetcode.numberOfRecentCalls

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfRecentCallsTest {
    private val recentCounter = NumberOfRecentCalls.RecentCounter()

    @Test
    fun test() {
        assertEquals(1, recentCounter.ping(1)) // requests = [1], range is [-2999,1], return 1
        assertEquals(
            2,
            recentCounter.ping(100),
        ) // requests = [1, 100], range is [-2900,100], return 2
        assertEquals(
            3,
            recentCounter.ping(3001),
        ) // requests = [1, 100, 3001], range is [1,3001], return 3
        assertEquals(
            3,
            recentCounter.ping(3002),
        ) // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
