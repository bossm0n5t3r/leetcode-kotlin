package me.bossm0n5t3r.leetcode.minimumCostForTickets

import java.util.LinkedList

class MinimumCostForTickets {
    class Solution {
        fun minCostTicketsUsingQueue(days: IntArray, costs: IntArray): Int {
            val sevenDayPass = LinkedList<Pair<Int, Int>>()
            val thirtyDayPass = LinkedList<Pair<Int, Int>>()
            var cost = 0
            days.forEach { day ->
                while (sevenDayPass.isNotEmpty() && sevenDayPass.peek().first + 7 <= day) {
                    sevenDayPass.poll()
                }
                while (thirtyDayPass.isNotEmpty() && thirtyDayPass.peek().first + 30 <= day) {
                    thirtyDayPass.poll()
                }
                sevenDayPass.add(day to (cost + costs[1]))
                thirtyDayPass.add(day to (cost + costs[2]))
                cost =
                    intArrayOf(
                            cost + costs[0],
                            sevenDayPass.peek().second,
                            thirtyDayPass.peek().second,
                        )
                        .minOrNull()!!
            }
            return cost
        }

        fun minCostTicketsUsingDP(days: IntArray, costs: IntArray): Int {
            val dp = IntArray(30) { 0 }
            var day = 0
            (days.first()..days.last()).forEach { i ->
                if (i != days[day]) {
                    dp[i % 30] = dp[(i - 1) % 30]
                } else {
                    dp[i % 30] =
                        listOf(
                                dp[(i - 1) % 30] + costs[0],
                                dp[(i - 7).coerceAtLeast(0) % 30] + costs[1],
                                dp[(i - 30).coerceAtLeast(0) % 30] + costs[2],
                            )
                            .minOrNull()!!
                    day++
                }
            }
            return dp[days.last() % 30]
        }
    }
}
