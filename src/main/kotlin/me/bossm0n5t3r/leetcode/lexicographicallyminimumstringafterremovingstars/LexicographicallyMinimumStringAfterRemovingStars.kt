package me.bossm0n5t3r.leetcode.lexicographicallyminimumstringafterremovingstars

import java.util.PriorityQueue

class LexicographicallyMinimumStringAfterRemovingStars {
    class Solution {
        fun clearStars(s: String): String {
            val priorityQueue =
                PriorityQueue(
                    compareBy<Pair<Char, Int>> { it.first }.thenByDescending { it.second }
                )
            for ((index, c) in s.withIndex()) {
                if (c != '*') {
                    priorityQueue.offer(c to index)
                    continue
                }
                priorityQueue.poll()
            }

            return priorityQueue.sortedBy { it.second }.map { it.first }.joinToString("")
        }
    }
}
