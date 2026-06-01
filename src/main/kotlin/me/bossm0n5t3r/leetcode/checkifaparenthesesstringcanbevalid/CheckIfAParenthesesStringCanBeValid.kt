package me.bossm0n5t3r.leetcode.checkifaparenthesesstringcanbevalid

class CheckIfAParenthesesStringCanBeValid {
    class Solution {
        fun canBeValid(s: String, locked: String): Boolean =
            s.length % 2 == 0 && validate(s, locked, '(') && validate(s, locked, ')')

        private fun validate(s: String, locked: String, op: Char): Boolean {
            var balance = 0
            var wild = 0
            val length = s.length
            val (start, direction) = if (op == '(') 0 to 1 else (length - 1) to -1
            var index = start
            while (index in 0 until length && wild + balance >= 0) {
                when (locked[index]) {
                    '1' -> balance += if (s[index] == op) 1 else -1
                    '0' -> wild++
                }
                index += direction
            }
            return abs(balance) <= wild
        }

        private fun abs(n: Int) = if (n >= 0) n else -n
    }
}
