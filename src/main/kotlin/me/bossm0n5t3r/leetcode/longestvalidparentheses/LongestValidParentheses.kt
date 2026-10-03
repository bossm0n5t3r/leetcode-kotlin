package me.bossm0n5t3r.leetcode.longestvalidparentheses

import kotlin.ranges.downTo

class LongestValidParentheses {
    class Solution {
        fun longestValidParentheses(s: String): Int {
            return maxOf(
                getLongestValidParentheses(s, s.indices),
                getLongestValidParentheses(s, s.lastIndex downTo 0),
            )
        }

        private fun getLongestValidParentheses(s: String, indexRange: IntProgression): Int {
            var result = 0
            var open = 0
            var close = 0

            for (i in indexRange) {
                if (s[i] == '(') open++ else close++

                if (open == close) {
                    result = maxOf(result, open + close)
                }

                val invalid =
                    if (indexRange.step > 0) {
                        close > open
                    } else {
                        open > close
                    }

                if (invalid) {
                    open = 0
                    close = 0
                }
            }

            return result
        }
    }
}
