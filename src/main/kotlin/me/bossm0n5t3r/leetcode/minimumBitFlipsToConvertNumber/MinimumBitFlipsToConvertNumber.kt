package me.bossm0n5t3r.leetcode.minimumBitFlipsToConvertNumber

class MinimumBitFlipsToConvertNumber {
    class Solution {
        fun minBitFlips(start: Int, goal: Int): Int =
            (start xor goal).toString(2).count { it == '1' }
    }
}
