package me.bossm0n5t3r.leetcode.kThSmallestPrimeFraction

class KThSmallestPrimeFraction {
    class Solution {
        fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
            val sortedArr = arr.sorted()
            val result = mutableListOf<IntArray>()
            for (i in 0 until arr.size - 1) {
                for (j in i + 1 until arr.size) {
                    result.add(intArrayOf(sortedArr[i], sortedArr[j]))
                }
            }
            return result.sortedBy { it[0].toDouble() / it[1].toDouble() }[k - 1]
        }
    }
}
