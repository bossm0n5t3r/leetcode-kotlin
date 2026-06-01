package me.bossm0n5t3r.leetcode.bitwisexorofallpairings

class BitwiseXOROfAllPairings {
    class Solution {
        fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
            val isNums1Even = nums1.size % 2 == 0
            val isNums2Even = nums2.size % 2 == 0
            return when {
                isNums1Even && isNums2Even -> 0
                isNums1Even -> nums1.reduce { acc, i -> acc xor i }
                isNums2Even -> nums2.reduce { acc, i -> acc xor i }
                else ->
                    nums1.reduce { acc, i -> acc xor i } xor nums2.reduce { acc, i -> acc xor i }
            }
        }
    }
}
