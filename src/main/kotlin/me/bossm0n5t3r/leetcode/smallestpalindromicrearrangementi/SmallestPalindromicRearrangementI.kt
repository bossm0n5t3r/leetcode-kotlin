package me.bossm0n5t3r.leetcode.smallestpalindromicrearrangementi

class SmallestPalindromicRearrangementI {
    class Solution {
        fun smallestPalindrome(s: String): String {
            val chars = IntArray(26) { 0 }
            for (c in s) chars[c - 'a']++
            val ascending = ArrayDeque<Char>()
            var turnOver = Char.MIN_VALUE
            val descending = ArrayDeque<Char>()
            for (i in 0 until 26) {
                val count = chars[i]
                when {
                    count == 0 -> continue
                    count % 2 == 0 -> {
                        repeat(count / 2) {
                            ascending.addLast('a' + i)
                            descending.addFirst('a' + i)
                        }
                    }
                    else -> {
                        val char = 'a' + i
                        turnOver = char
                        repeat(count / 2) {
                            ascending.addLast('a' + i)
                            descending.addFirst('a' + i)
                        }
                    }
                }
            }
            return buildString {
                append(ascending.toCharArray())
                if (turnOver != Char.MIN_VALUE) append(turnOver)
                append(descending.toCharArray())
            }
        }
    }
}
