package me.bossm0n5t3r.leetcode.smallestdivisibledigitproductii

class SmallestDivisibleDigitProductII {
    class Solution {
        fun smallestNumber(num: String, t: Long): String {
            val (remainder, factorization) = t.factorization()
            if (remainder > 0) return "-1"

            val n = num.length

            val prefixNeed = Array(n + 1) { LongArray(4) }
            val hasZeroPrefix = BooleanArray(n + 1)
            prefixNeed[0] = factorization.copyOf()
            for (i in num.indices) {
                prefixNeed[i + 1] = prefixNeed[i].copyOf()
                prefixNeed[i + 1].subtract(DIGIT_FACTORS[num[i] - '0'])
                hasZeroPrefix[i + 1] = hasZeroPrefix[i] || num[i] == '0'
            }

            if (!hasZeroPrefix[n] && prefixNeed[n].all { it == 0L }) return num

            for (p in n - 1 downTo 0) {
                if (hasZeroPrefix[p]) continue
                val curNeed = prefixNeed[p]
                val lower = num[p] - '0'
                for (d in lower + 1..9) {
                    val nextNeed = curNeed.copyOf()
                    nextNeed.subtract(DIGIT_FACTORS[d])
                    val remainingPositions = n - p - 1
                    if (feasible(nextNeed, remainingPositions)) {
                        val suffix = smallestSuffix(nextNeed, remainingPositions)
                        return num.substring(0, p) + d + suffix
                    }
                }
            }

            val minLen = generateSequence(1) { it + 1 }.first { feasible(factorization, it) }
            val totalLen = maxOf(n + 1, minLen)
            val leadingOnes = totalLen - minLen
            return "1".repeat(leadingOnes) + smallestSuffix(factorization, minLen)
        }

        private fun feasible(need: LongArray, k: Int): Boolean {
            val a = need[0]
            val b = need[1]
            val c = need[2]
            val d = need[3]
            if (c + d > k) return false

            val m = k - c - d
            if (a == 0L && b == 0L) return true

            val max6 = minOf(m, a, b)
            for (x6 in 0L..max6) {
                val rem2 = maxOf(0L, a - x6)
                val rem3 = maxOf(0L, b - x6)
                val remDigits = m - x6
                val min2Digits = if (rem2 == 0L) 0L else (rem2 + 2) / 3
                val min3Digits = if (rem3 == 0L) 0L else (rem3 + 1) / 2
                if (min2Digits + min3Digits <= remDigits) return true
            }
            return false
        }

        private fun smallestSuffix(need: LongArray, length: Int): String {
            if (length == 0) return ""
            val cur = need.copyOf()
            val sb = StringBuilder(length)
            for (i in 0 until length) {
                for (d in 1..9) {
                    val next = cur.copyOf()
                    next.subtract(DIGIT_FACTORS[d])
                    if (feasible(next, length - i - 1)) {
                        sb.append('0' + d)
                        cur.subtract(DIGIT_FACTORS[d])
                        break
                    }
                }
            }
            return sb.toString()
        }

        private fun LongArray.subtract(factors: IntArray) {
            for (i in factors.indices) {
                this[i] = maxOf(0L, this[i] - factors[i])
            }
        }

        private fun Long.factorization(): Pair<Long, LongArray> {
            val result = LongArray(4) { 0 }
            var tmp = this
            while (tmp > 1) {
                when {
                    tmp % 2 == 0L -> {
                        result[0]++
                        tmp /= 2
                    }

                    tmp % 3 == 0L -> {
                        result[1]++
                        tmp /= 3
                    }

                    tmp % 5 == 0L -> {
                        result[2]++
                        tmp /= 5
                    }

                    tmp % 7 == 0L -> {
                        result[3]++
                        tmp /= 7
                    }

                    else -> break
                }
            }
            return if (tmp > 1) tmp to result else 0L to result
        }

        companion object {
            private val DIGIT_FACTORS =
                arrayOf(
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(2, 0, 0, 0),
                    intArrayOf(0, 0, 1, 0),
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(0, 0, 0, 1),
                    intArrayOf(3, 0, 0, 0),
                    intArrayOf(0, 2, 0, 0),
                )
        }
    }
}
