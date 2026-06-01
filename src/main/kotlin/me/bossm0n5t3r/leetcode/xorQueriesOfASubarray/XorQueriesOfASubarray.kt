package me.bossm0n5t3r.leetcode.xorQueriesOfASubarray

class XorQueriesOfASubarray {
    class Solution {
        fun xorQueries(arr: IntArray, queries: Array<IntArray>): IntArray =
            queries
                .map { (left, right) ->
                    (left + 1..right).fold(arr[left]) { acc, i -> acc xor arr[i] }
                }
                .toIntArray()
    }
}
