package me.bossm0n5t3r.leetcode.processstringwithspecialoperationsii

class ProcessStringWithSpecialOperationsII {
    class Solution {
        fun processStr(s: String, k: Long): Char {
            var length = getTotalResultLength(s)
            if (k + 1 > length) return '.'
            var targetPoint = k
            for (c in s.reversed()) {
                when (c) {
                    '*' -> length++
                    '#' -> {
                        val oldLength = length / 2
                        if (oldLength > 0L) targetPoint %= oldLength
                        length = oldLength
                    }
                    '%' -> targetPoint = length - 1 - targetPoint
                    else -> if (targetPoint == length - 1) return c else length--
                }
            }
            return '.'
        }

        private fun getTotalResultLength(s: String): Long {
            var length = 0L
            for (c in s) {
                when (c) {
                    '*' -> if (length > 0) length--
                    '#' -> length *= 2
                    '%' -> continue
                    else -> length++
                }
            }
            return length
        }
    }
}
