package me.bossm0n5t3r.leetcode.minimumnumberofpushestotypewordii

import java.util.PriorityQueue

class MinimumNumberOfPushesToTypeWordII {
    class Solution {
        fun minimumPushes(word: String): Int {
            val frequency = mutableMapOf<Char, Int>()
            for (char in word) {
                frequency[char] = frequency.getOrDefault(char, 0) + 1
            }
            val pq = PriorityQueue<Int>(compareByDescending { it })
            pq.addAll(frequency.values)
            var result = 0
            var digits = 8
            var push = 1
            while (pq.isNotEmpty()) {
                val cur = pq.poll()
                result += cur * push
                digits--
                if (digits == 0) {
                    digits = 8
                    push++
                }
            }
            return result
        }
    }
}
