package me.bossm0n5t3r.leetcode.maximizeHappinessOfSelectedChildren

import java.util.LinkedList
import java.util.Queue

class MaximizeHappinessOfSelectedChildren {
    class Solution {
        fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
            val happinessQueue =
                LinkedList<Long>().apply {
                    this.addAll(happiness.map { it.toLong() }.sortedDescending())
                } as Queue<Long>

            var result = 0L
            var tmp = 0
            while (tmp < k) {
                result += (happinessQueue.poll() - tmp++).coerceAtLeast(0L)
            }
            return result
        }
    }
}
