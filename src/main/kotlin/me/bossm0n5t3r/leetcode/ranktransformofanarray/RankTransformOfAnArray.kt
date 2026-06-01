package me.bossm0n5t3r.leetcode.ranktransformofanarray

class RankTransformOfAnArray {
    class Solution {
        fun arrayRankTransform(arr: IntArray): IntArray {
            val numToRank =
                arr.toList()
                    .groupBy { it }
                    .keys
                    .sorted()
                    .mapIndexed { index, i -> i to index + 1 }
                    .toMap()
            return arr.toList().mapNotNull { numToRank[it] }.toIntArray()
        }
    }
}
