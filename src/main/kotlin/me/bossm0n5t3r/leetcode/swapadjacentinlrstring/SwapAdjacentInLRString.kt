package me.bossm0n5t3r.leetcode.swapadjacentinlrstring

class SwapAdjacentInLRString {
    class Solution {
        fun canTransform(start: String, result: String): Boolean {
            val n = start.length
            var startIndex = 0
            var resultIndex = 0
            while (startIndex <= n && resultIndex <= n) {
                while (startIndex < n && start[startIndex] == 'X') {
                    startIndex++
                }
                while (resultIndex < n && result[resultIndex] == 'X') {
                    resultIndex++
                }
                if (startIndex == n || resultIndex == n) return startIndex == n && resultIndex == n
                if (start[startIndex] != result[resultIndex]) return false
                if (result[resultIndex] == 'L' && startIndex < resultIndex) return false
                if (result[resultIndex] == 'R' && resultIndex < startIndex) return false
                startIndex++
                resultIndex++
            }
            return true
        }
    }
}
