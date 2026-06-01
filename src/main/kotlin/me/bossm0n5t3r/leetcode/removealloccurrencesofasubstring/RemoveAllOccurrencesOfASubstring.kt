package me.bossm0n5t3r.leetcode.removealloccurrencesofasubstring

class RemoveAllOccurrencesOfASubstring {
    class Solution {
        fun removeOccurrences(s: String, part: String): String {
            var tmp = s
            while (tmp.contains(part)) {
                tmp = tmp.replaceFirst(part, "")
            }
            return tmp
        }
    }
}
