package me.bossm0n5t3r.leetcode.reversedegreeofastring

class ReverseDegreeOfAString {
    class Solution {
        fun reverseDegree(s: String): Int {
            return s.withIndex().sumOf { (index, char) -> (26 - (char - 'a')) * (index + 1) }
        }
    }
}
