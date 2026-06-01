package me.bossm0n5t3r.leetcode.timeNeededToBuyTickets

class TimeNeededToBuyTickets {
    class Solution {
        fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
            var time = 0
            for (i in tickets.indices) {
                time +=
                    if (i <= k) {
                        minOf(tickets[i], tickets[k])
                    } else {
                        minOf(tickets[i], tickets[k] - 1)
                    }
            }
            return time
        }
    }
}
