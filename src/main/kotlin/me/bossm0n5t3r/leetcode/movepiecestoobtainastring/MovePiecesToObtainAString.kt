package me.bossm0n5t3r.leetcode.movepiecestoobtainastring

class MovePiecesToObtainAString {
    class Solution {
        fun canChange(start: String, target: String): Boolean {
            val n = start.length
            var startIndex = 0
            var targetIndex = 0
            while (startIndex <= n && targetIndex <= n) {
                while (startIndex < n && start[startIndex] == '_') {
                    startIndex++
                }
                while (targetIndex < n && target[targetIndex] == '_') {
                    targetIndex++
                }
                if (startIndex == n || targetIndex == n) return startIndex == n && targetIndex == n
                if (start[startIndex] != target[targetIndex]) return false
                if (target[targetIndex] == 'L' && startIndex < targetIndex) return false
                if (target[targetIndex] == 'R' && targetIndex < startIndex) return false
                startIndex++
                targetIndex++
            }
            return true
        }
    }
}
