package me.bossm0n5t3r.leetcode.handOfStraights

class HandOfStraights {
    class Solution {
        fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
            if (hand.size % groupSize != 0) return false
            val intToCount = hand.toList().groupingBy { it }.eachCount().toMutableMap()
            val sortedKeys = intToCount.keys.sorted()
            for (key in sortedKeys) {
                var count = intToCount.getOrElse(key) { 0 }
                while (count-- > 0) {
                    for (i in 1 until groupSize) {
                        val nextCount = intToCount[key + i]?.takeIf { it > 0 } ?: return false
                        intToCount[key + i] = nextCount - 1
                    }
                }
                intToCount.remove(key)
            }
            return true
        }
    }
}
