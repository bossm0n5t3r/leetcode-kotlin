package me.bossm0n5t3r.leetcode.removingStarsFromAString

import java.util.Stack

class RemovingStarsFromAString {
    class Solution {
        fun removeStars(s: String): String {
            val result = Stack<Char>()
            for (c in s) {
                when (c) {
                    '*' -> {
                        if (result.isNotEmpty()) {
                            result.pop()
                        }
                    }

                    else -> {
                        result.push(c)
                    }
                }
            }
            return result.joinToString("")
        }

        fun removeStarsWithoutUsingStack(s: String): String {
            val result = s.toCharArray()
            var lastIdx = 0
            for (c in s) {
                when (c) {
                    '*' -> {
                        if (lastIdx > 0) {
                            lastIdx--
                        }
                    }

                    else -> {
                        result[lastIdx++] = c
                    }
                }
            }
            return result.take(lastIdx).joinToString("")
        }
    }
}
