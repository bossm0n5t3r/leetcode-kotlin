package me.bossm0n5t3r.leetcode.maximumNumberOfIntegersToChooseFromARangeI

class MaximumNumberOfIntegersToChooseFromARangeI {
    class Solution {
        fun maxCount(banned: IntArray, n: Int, maxSum: Int): Int {
            val bannedSet = banned.toSet()
            val candidates =
                (1..n)
                    .toList()
                    .asSequence()
                    .filterNot { bannedSet.contains(it) }
                    .toCollection(mutableListOf())
            var tmpSum = 0
            for (i in candidates.indices) {
                if (tmpSum + candidates[i] > maxSum) {
                    return i
                }
                tmpSum += candidates[i]
            }
            return candidates.size
        }
    }
}
