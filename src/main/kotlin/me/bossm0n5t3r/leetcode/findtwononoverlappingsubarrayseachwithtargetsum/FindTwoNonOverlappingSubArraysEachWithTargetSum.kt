package me.bossm0n5t3r.leetcode.findtwononoverlappingsubarrayseachwithtargetsum

class FindTwoNonOverlappingSubArraysEachWithTargetSum {
    class Solution {
        fun minSumOfLengths(arr: IntArray, target: Int): Int {
            var left = 0
            var sum = 0
            var answer = Int.MAX_VALUE
            val n = arr.size
            val prefixBest = IntArray(n)
            for (right in 0 until n) {
                sum += arr[right]
                while (sum > target) {
                    sum -= arr[left]
                    left++
                }
                prefixBest[right] = if (right > 0) prefixBest[right - 1] else Int.MAX_VALUE
                if (sum == target) {
                    val currentLength = right - left + 1
                    if (left > 0 && prefixBest[left - 1] != Int.MAX_VALUE) {
                        answer = minOf(answer, prefixBest[left - 1] + currentLength)
                    }
                    prefixBest[right] = minOf(prefixBest[right], currentLength)
                }
            }
            return if (answer != Int.MAX_VALUE) answer else -1
        }
    }
}
