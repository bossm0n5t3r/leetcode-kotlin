package me.bossm0n5t3r.leetcode.maximumnumberofnonoverlappingsubstrings

class MaximumNumberOfNonOverlappingSubstrings {
    class Solution {
        fun maxNumOfSubstrings(s: String): List<String> {
            val firstIndex = IntArray(26) { s.length }
            val lastIndex = IntArray(26) { -1 }
            for ((index, c) in s.withIndex()) {
                firstIndex[c - 'a'] = minOf(firstIndex[c - 'a'], index)
                lastIndex[c - 'a'] = maxOf(lastIndex[c - 'a'], index)
            }
            val candidates = mutableListOf<Pair<Int, Int>>()
            for (i in 0 until 26) {
                if (firstIndex[i] == s.length) continue
                val left = firstIndex[i]
                var right = lastIndex[i]
                var valid = true
                var i = left
                while (i <= right) {
                    val char = s[i]
                    if (firstIndex[char - 'a'] < left) {
                        valid = false
                        break
                    }
                    right = maxOf(right, lastIndex[char - 'a'])
                    i++
                }
                if (valid) candidates += left to right
            }
            val sortedCandidates = candidates.sortedBy { it.second }
            val result = mutableListOf<String>()
            var previousEnd = -1
            for ((left, right) in sortedCandidates) {
                if (left > previousEnd) {
                    result += s.substring(left..right)
                    previousEnd = right
                }
            }
            return result
        }
    }
}
