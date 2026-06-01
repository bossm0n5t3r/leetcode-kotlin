package me.bossm0n5t3r.leetcode.stringToInteger

import java.math.BigInteger

class StringToInteger {
    class Solution {
        fun myAtoi(s: String): Int = s.step1().step2().step3().step4().step5()

        private fun String.step1(): Pair<Char, String> = '+' to this.trim()

        private fun Pair<Char, String>.step2(): Pair<Char, String> =
            if (this.second.isNotEmpty() && this.second[0] == '-') {
                '-' to this.second.substring(1)
            } else {
                val tmp =
                    if (this.second.isNotEmpty() && this.second[0] == '+') {
                        this.second.substring(1)
                    } else {
                        this.second
                    }
                this.first to tmp
            }

        companion object {
            // Use companion object for testing
            fun Pair<Char, String>.step3(): Pair<Char, String> {
                var idx = 0
                while (idx < this.second.length && this.second[idx].isDigit()) {
                    idx++
                }
                return this.first to this.second.substring(0, idx)
            }
        }

        private fun Pair<Char, String>.step4(): BigInteger {
            val tmp =
                if (this.second.isNotEmpty()) {
                    this.second.toBigInteger()
                } else {
                    BigInteger.valueOf(0L)
                }
            return if (this.first == '-') {
                tmp.times(BigInteger.valueOf(-1L))
            } else {
                tmp
            }
        }

        private fun BigInteger.step5(): Int =
            when {
                this < BigInteger.valueOf(Int.MIN_VALUE.toLong()) -> {
                    Int.MIN_VALUE
                }

                this > BigInteger.valueOf(Int.MAX_VALUE.toLong()) -> {
                    Int.MAX_VALUE
                }

                else -> {
                    this.toInt()
                }
            }
    }
}
