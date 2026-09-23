package me.bossm0n5t3r.leetcode.minimumoperationstoreducextozero

class MinimumOperationsToReduceXToZero {
    class Solution {
        fun minOperations(nums: IntArray, x: Int): Int {
            val n = nums.size

            // prefixSum -> prefix의 마지막 index
            // 아무것도 선택하지 않은 prefix도 필요
            val prefixSumMap = mutableMapOf(0 to -1)

            var prefixSum = 0
            for (i in nums.indices) {
                prefixSum += nums[i]
                prefixSumMap[prefixSum] = i
            }

            var suffixSum = 0
            var result = Int.MAX_VALUE

            // i부터 끝까지가 suffix
            for (i in n downTo 0) {
                if (i < n) {
                    suffixSum += nums[i]
                }

                val neededPrefixSum = x - suffixSum
                val prefixIndex = prefixSumMap[neededPrefixSum] ?: continue

                // prefix와 suffix가 겹치면 안 됨
                if (prefixIndex >= i) continue

                val prefixLength = prefixIndex + 1
                val suffixLength = n - i

                result = minOf(result, prefixLength + suffixLength)
            }

            return if (result == Int.MAX_VALUE) -1 else result
        }
    }
}
