package me.bossm0n5t3r.leetcode.countingBits

class CountingBits {
    class Solution {
        fun countBits(n: Int): IntArray = (0..n).map { i -> Integer.bitCount(i) }.toIntArray()
    }
}
