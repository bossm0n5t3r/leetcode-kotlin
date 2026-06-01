package me.bossm0n5t3r.leetcode.specialarrayi

class SpecialArrayI {
    class Solution {
        fun isArraySpecial(nums: IntArray): Boolean =
            nums.toList().windowed(2).all { it.sum() % 2 == 1 }
    }
}
