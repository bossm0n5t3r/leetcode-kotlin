package me.bossm0n5t3r.leetcode.validParenthesisString

class ValidParenthesisString {
    class Solution {
        fun checkValidString(s: String): Boolean {
            var (leftMin, leftMax) = 0 to 0
            for (c in s) {
                when (c) {
                    '(' -> {
                        leftMin++
                        leftMax++
                    }

                    ')' -> {
                        leftMin--
                        leftMax--
                    }

                    '*' -> {
                        leftMin--
                        leftMax++
                    }
                }
                if (leftMax < 0) return false
                if (leftMin < 0) leftMin = 0
            }
            return leftMin == 0
        }
    }
}
