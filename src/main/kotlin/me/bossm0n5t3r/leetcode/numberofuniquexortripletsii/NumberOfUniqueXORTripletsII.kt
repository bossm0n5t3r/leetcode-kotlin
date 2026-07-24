package me.bossm0n5t3r.leetcode.numberofuniquexortripletsii

class NumberOfUniqueXORTripletsII {
    class Solution {
        fun uniqueXorTriplets(nums: IntArray): Int {
            val tmp = BooleanArray(1501)
            val values = mutableSetOf<Int>()
            for (num in nums) {
                if (tmp[num]) continue
                tmp[num] = true
                values += num
            }
            var reachable = BooleanArray(2048)
            reachable[0] = true

            repeat(3) {
                val next = BooleanArray(2048)
                for (xorValue in reachable.indices) {
                    if (!reachable[xorValue]) continue
                    for (value in values) {
                        next[xorValue xor value] = true
                    }
                }
                reachable = next
            }

            return reachable.count { it }
        }
    }
}
