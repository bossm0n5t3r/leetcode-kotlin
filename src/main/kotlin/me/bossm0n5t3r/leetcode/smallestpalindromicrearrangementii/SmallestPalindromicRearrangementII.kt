package me.bossm0n5t3r.leetcode.smallestpalindromicrearrangementii

import java.math.BigInteger

class SmallestPalindromicRearrangementII {
    class Solution {
        fun smallestPalindrome(s: String, k: Int): String {
            val frequency = IntArray(26)
            for (char in s) {
                frequency[char - 'a']++
            }

            val firstHalf = buildFirstHalfString(frequency, s, k) ?: return ""
            val (result, middle) = firstHalf
            val halfLength = result.length
            if (middle >= 0) {
                result.append('a' + middle)
            }
            for (i in halfLength - 1 downTo 0) {
                result.append(result[i])
            }

            return result.toString()
        }

        private fun buildFirstHalfString(
            frequency: IntArray,
            s: String,
            k: Int,
        ): Pair<StringBuilder, Int>? {
            val halfFrequency = IntArray(26)
            var middle = -1

            for (i in frequency.indices) {
                halfFrequency[i] = frequency[i] / 2
                if (frequency[i] % 2 != 0) {
                    middle = i
                }
            }

            var ways = factorial(s.length / 2)
            for (count in halfFrequency) {
                ways /= factorial(count)
            }

            var rank = BigInteger.valueOf(k.toLong())
            if (ways < rank) return null

            val result = StringBuilder(s.length)
            var remaining = s.length / 2

            while (remaining > 0) {
                for (i in halfFrequency.indices) {
                    val count = halfFrequency[i]
                    if (count == 0) continue

                    val nextWays =
                        ways
                            .multiply(BigInteger.valueOf(count.toLong()))
                            .divide(BigInteger.valueOf(remaining.toLong()))

                    if (rank > nextWays) {
                        rank -= nextWays
                        continue
                    }

                    result.append('a' + i)
                    halfFrequency[i]--
                    ways = nextWays
                    remaining--
                    break
                }
            }

            return result to middle
        }

        private fun factorial(n: Int): BigInteger {
            var result = BigInteger.ONE
            for (i in 2..n) {
                result *= BigInteger.valueOf(i.toLong())
            }
            return result
        }
    }
}
