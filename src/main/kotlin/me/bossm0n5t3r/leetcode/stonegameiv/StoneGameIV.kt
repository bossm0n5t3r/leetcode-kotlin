package me.bossm0n5t3r.leetcode.stonegameiv

class StoneGameIV {
    class Solution {
        fun winnerSquareGame(n: Int): Boolean {
            val memo = mutableMapOf(0 to false)

            fun canWin(remaining: Int): Boolean {
                val cached = memo[remaining]
                if (cached != null) return cached

                var times = 1
                while (times * times <= remaining) {
                    if (!canWin(remaining - times * times)) {
                        memo[remaining] = true
                        return true
                    }
                    times++
                }

                memo[remaining] = false
                return false
            }

            return canWin(n)
        }
    }
}
