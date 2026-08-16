package me.bossm0n5t3r.leetcode.stonegameix

class StoneGameIX {
    class Solution {
        fun stoneGameIX(stones: IntArray): Boolean {
            val count = IntArray(3) { 0 }
            for (stone in stones) {
                count[stone % 3]++
            }
            return if (count[0] % 2 == 0) {
                count[1] >= 1 && count[2] >= 1
            } else {
                count[1] - count[2] > 2 || count[2] - count[1] > 2
            }
        }
    }
}
