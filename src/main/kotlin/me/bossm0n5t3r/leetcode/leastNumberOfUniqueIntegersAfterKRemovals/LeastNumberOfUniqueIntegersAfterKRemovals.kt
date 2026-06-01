package me.bossm0n5t3r.leetcode.leastNumberOfUniqueIntegersAfterKRemovals

class LeastNumberOfUniqueIntegersAfterKRemovals {
    class Solution {
        fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int =
            arr.toList()
                .groupingBy { it }
                .eachCount()
                .toList()
                .sortedBy { (_, v) -> v }
                .flatMap { (number, count) -> Array(count) { number }.toList() }
                .subList(k, arr.size)
                .toSet()
                .size
    }
}
