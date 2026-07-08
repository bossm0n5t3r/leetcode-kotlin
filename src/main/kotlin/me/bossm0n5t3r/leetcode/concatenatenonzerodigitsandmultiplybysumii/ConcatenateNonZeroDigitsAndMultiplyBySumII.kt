package me.bossm0n5t3r.leetcode.concatenatenonzerodigitsandmultiplybysumii

class ConcatenateNonZeroDigitsAndMultiplyBySumII {
    class Solution {
        private companion object {
            const val MODULO = 1_000_000_007L
        }

        fun sumAndMultiply(s: String, queries: Array<IntArray>): IntArray {
            val n = s.length
            val prefixVal = LongArray(n + 1)
            val prefixSum = LongArray(n + 1)
            val cnt = IntArray(n + 1)
            for (i in 0 until n) {
                val d = s[i].digitToInt()
                val isZero = d == 0
                prefixVal[i + 1] = if (isZero) prefixVal[i] else (prefixVal[i] * 10 + d) % MODULO
                prefixSum[i + 1] = prefixSum[i] + if (isZero) 0L else d.toLong()
                cnt[i + 1] = cnt[i] + if (isZero) 0 else 1
            }
            val maxCnt = cnt[n]
            val pow10 =
                LongArray(maxCnt + 1).apply {
                    this[0] = 1
                    for (i in 1..maxCnt) this[i] = this[i - 1] * 10 % MODULO
                }
            return queries
                .map { (l, r) ->
                    val k = cnt[r + 1] - cnt[l]
                    val rangeVal =
                        ((prefixVal[r + 1] - prefixVal[l] * pow10[k]) % MODULO + MODULO) % MODULO
                    val rangeSum = (prefixSum[r + 1] - prefixSum[l]) % MODULO
                    ((rangeVal * rangeSum) % MODULO).toInt()
                }
                .toIntArray()
        }
    }
}
