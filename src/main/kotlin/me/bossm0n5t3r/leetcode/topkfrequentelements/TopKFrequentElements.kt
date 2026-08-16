package me.bossm0n5t3r.leetcode.topkfrequentelements

import java.util.PriorityQueue

class TopKFrequentElements {
    class Solution {
        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            val frequency = nums.toList().groupingBy { it }.eachCount()
            val pq =
                PriorityQueue(
                    compareByDescending<Pair<Int, Int>> { it.second }.thenComparing { it.first }
                )
            pq.addAll(frequency.toList())
            return buildList {
                    repeat(k) {
                        val (num, _) = pq.poll()
                        add(num)
                    }
                }
                .toIntArray()
        }
    }
}
