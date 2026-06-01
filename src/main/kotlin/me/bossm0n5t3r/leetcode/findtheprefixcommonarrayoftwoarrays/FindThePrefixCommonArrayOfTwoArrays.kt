package me.bossm0n5t3r.leetcode.findtheprefixcommonarrayoftwoarrays

class FindThePrefixCommonArrayOfTwoArrays {
    class Solution {
        fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
            val prefixA = mutableSetOf<Int>()
            val prefixB = mutableSetOf<Int>()
            return A.zip(B)
                .map {
                    prefixA.add(it.first)
                    prefixB.add(it.second)
                    prefixA.intersect(prefixB).size
                }
                .toIntArray()
        }
    }
}
