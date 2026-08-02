package me.bossm0n5t3r.leetcode.stonegame

class StoneGame {
    class Solution {
        fun stoneGame(piles: IntArray): Boolean {
            val n = piles.size
            val memo = Array(n) { IntArray(n) { Int.MIN_VALUE } }

            fun scoreDiff(i: Int, j: Int): Int {
                if (i == j) return piles[i]
                if (memo[i][j] != Int.MIN_VALUE) return memo[i][j]

                val takeLeft = piles[i] - scoreDiff(i + 1, j)
                val takeRight = piles[j] - scoreDiff(i, j - 1)

                memo[i][j] = maxOf(takeLeft, takeRight)
                return memo[i][j]
            }

            return scoreDiff(0, n - 1) >= 0
        }
    }
}
