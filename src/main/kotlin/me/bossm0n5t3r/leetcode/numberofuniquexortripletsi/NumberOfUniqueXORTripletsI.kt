package me.bossm0n5t3r.leetcode.numberofuniquexortripletsi

import java.math.BigInteger

class NumberOfUniqueXORTripletsI {
    class Solution {
        fun uniqueXorTriplets(nums: IntArray): Int {
            val n = nums.size
            if (n <= 2) return n
            return BigInteger.TWO.pow(32 - n.countLeadingZeroBits()).toInt()
        }
    }
}
