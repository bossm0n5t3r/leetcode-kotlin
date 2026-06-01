package me.bossm0n5t3r.leetcode.numberOfRecentCalls

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfRecentCallsTest {
    private val recentCounter = NumberOfRecentCalls.RecentCounter()

    @Test
    fun test() {
        assertEquals(recentCounter.ping(1), 1) // requests = [1], range is [-2999,1], return 1
        assertEquals(
            recentCounter.ping(100),
            2,
        ) // requests = [1, 100], range is [-2900,100], return 2
        assertEquals(
            recentCounter.ping(3001),
            3,
        ) // requests = [1, 100, 3001], range is [1,3001], return 3
        assertEquals(
            recentCounter.ping(3002),
            3,
        ) // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
