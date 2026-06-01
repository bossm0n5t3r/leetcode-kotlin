package me.bossm0n5t3r.leetcode.addingSpacesToAString

class AddingSpacesToAString {
    class Solution {
        fun addSpaces(s: String, spaces: IntArray): String {
            val stringBuilder = StringBuilder()
            var spaceIndex = 0
            for (i in s.indices) {
                if (spaceIndex < spaces.size && spaces[spaceIndex] == i) {
                    stringBuilder.append(" ")
                    spaceIndex++
                }
                stringBuilder.append(s[i])
            }
            return stringBuilder.toString()
        }
    }
}
