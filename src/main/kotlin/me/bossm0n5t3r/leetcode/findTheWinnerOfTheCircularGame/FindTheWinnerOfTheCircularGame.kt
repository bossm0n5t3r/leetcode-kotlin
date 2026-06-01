package me.bossm0n5t3r.leetcode.findTheWinnerOfTheCircularGame

class FindTheWinnerOfTheCircularGame {
    class Solution {
        fun findTheWinner(n: Int, k: Int): Int {
            var result = 0
            for (playerNum in 2..n) {
                result = (result + k) % playerNum
            }
            return result + 1
        }
    }
}
