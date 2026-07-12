package me.bossm0n5t3r.leetcode.ranktransformofanarray

class RankTransformOfAnArray {
    class Solution {
        fun arrayRankTransform(arr: IntArray): IntArray {
            val sorted = arr.sortedArray()
            val numToRank = mutableMapOf<Int, Int>()
            var rank = 0
            for (num in sorted) {
                if (num !in numToRank) {
                    numToRank[num] = ++rank
                }
            }
            return IntArray(arr.size) { numToRank.getValue(arr[it]) }
        }
    }
}
