package me.bossm0n5t3r.leetcode.reverseString

class ReverseString {
    class Solution {
        private var tmpChar: Char = '\u0000'

        fun reverseString(s: CharArray): CharArray {
            val length = s.size
            val halfLength = length / 2
            for (i in 0 until halfLength) {
                swap(s, i, length - 1 - i)
            }
            return s
        }

        private fun swap(s: CharArray, i: Int, j: Int) {
            tmpChar = s[i]
            s[i] = s[j]
            s[j] = tmpChar
        }
    }
}
