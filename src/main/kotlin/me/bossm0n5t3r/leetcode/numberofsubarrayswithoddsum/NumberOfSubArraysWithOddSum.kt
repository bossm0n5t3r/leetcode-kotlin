package me.bossm0n5t3r.leetcode.numberofsubarrayswithoddsum

class NumberOfSubArraysWithOddSum {
    class Solution {
        fun numOfSubarrays(arr: IntArray): Int {
            val mod = 1_000_000_007
            for (i in arr.indices) {
                arr[i] %= 2
            }
            val dpOne = IntArray(arr.size)
            val dpZero = IntArray(arr.size)
            if (arr[arr.lastIndex] == 1) {
                dpOne[arr.lastIndex] = 1
            } else {
                dpZero[arr.lastIndex] = 1
            }
            for (i in arr.size - 2 downTo 0) {
                when (arr[i]) {
                    0 -> {
                        dpZero[i] = (1 + dpZero[i + 1]) % mod
                        dpOne[i] = dpOne[i + 1]
                    }

                    1 -> {
                        dpOne[i] = (1 + dpZero[i + 1]) % mod
                        dpZero[i] = dpOne[i + 1]
                    }
                }
            }
            return dpOne.reduce { acc, i -> (acc + i) % mod }
        }
    }
}
