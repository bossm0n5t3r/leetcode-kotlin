package me.bossm0n5t3r.leetcode.makestringasubsequenceusingcyclicincrements

class MakeStringASubsequenceUsingCyclicIncrements {
    class Solution {
        fun canMakeSubsequence(
            str1: String,
            str2: String,
        ): Boolean {
            var str1Index = 0
            var str2Index = 0
            while (str1Index < str1.length && str2Index < str2.length) {
                when {
                    str1[str1Index] == str2[str2Index] -> {
                        str1Index++
                        str2Index++
                    }

                    else -> {
                        val beforeChar = if (str2[str2Index] == 'a') 'z' else str2[str2Index] - 1
                        if (str1[str1Index] == beforeChar) {
                            str1Index++
                            str2Index++
                            continue
                        }
                        str1Index++
                    }
                }
            }
            return str2Index == str2.length
        }
    }
}
