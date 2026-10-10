package me.bossm0n5t3r.leetcode.minimumsumofsquareddifference

import java.util.TreeMap

class MinimumSumOfSquaredDifference {
    class Solution {
        fun minSumSquareDiff(nums1: IntArray, nums2: IntArray, k1: Int, k2: Int): Long {
            val frequency = TreeMap<Long, Long>()

            for (i in nums1.indices) {
                val diff = abs(nums1[i].toLong() - nums2[i])
                frequency[diff] = frequency.getOrDefault(diff, 0L) + 1
            }

            var times = k1.toLong() + k2.toLong()

            while (times > 0) {
                val maxEntry = frequency.lastEntry()
                val maxDiff = maxEntry.key
                val count = maxEntry.value

                if (maxDiff == 0L) break

                frequency.remove(maxDiff)

                val nextMaxDiff = frequency.lastKeyOrNull() ?: 0L
                val cost = (maxDiff - nextMaxDiff) * count

                if (times >= cost) {
                    // 최대값 그룹 전체를 다음 최대값까지 한 번에 내림
                    frequency[nextMaxDiff] = frequency.getOrDefault(nextMaxDiff, 0L) + count

                    times -= cost
                } else {
                    // 다음 최대값까지는 못 내려가므로
                    // 남은 연산을 count개에 최대한 균등하게 분배
                    val decrease = times / count
                    val remainder = times % count

                    val newDiff = maxDiff - decrease

                    // remainder개는 한 번 더 감소
                    if (remainder > 0) {
                        frequency[newDiff - 1] = frequency.getOrDefault(newDiff - 1, 0L) + remainder
                    }

                    // 나머지는 decrease만큼만 감소
                    val rest = count - remainder
                    if (rest > 0) {
                        frequency[newDiff] = frequency.getOrDefault(newDiff, 0L) + rest
                    }

                    times = 0
                }
            }

            var result = 0L

            for ((diff, count) in frequency) {
                result += diff * diff * count
            }

            return result
        }

        private fun TreeMap<Long, Long>.lastKeyOrNull(): Long? {
            return if (isEmpty()) null else lastKey()
        }

        private fun abs(n: Long) = if (n >= 0L) n else -n
    }
}
