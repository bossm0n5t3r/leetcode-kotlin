package me.bossm0n5t3r.leetcode.minimuminsertionstobalanceaparenthesesstring

class MinimumInsertionsToBalanceAParenthesesString {
    class Solution {
        fun minInsertions(s: String): Int {
            var result = 0
            var need = 0
            for (c in s) {
                when (c) {
                    '(' -> {
                        if (need % 2 == 1) {
                            result++
                            need--
                        }
                        need += 2
                    }
                    ')' -> {
                        need--
                        if (need < 0) {
                            result++
                            need = 1
                        }
                    }
                }
            }
            return result + need
        }
    }
}
