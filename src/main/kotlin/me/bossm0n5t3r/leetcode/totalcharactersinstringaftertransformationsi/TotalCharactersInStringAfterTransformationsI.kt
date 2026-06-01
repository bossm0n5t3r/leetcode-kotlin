package me.bossm0n5t3r.leetcode.totalcharactersinstringaftertransformationsi

class TotalCharactersInStringAfterTransformationsI {
    class Solution {
        fun lengthAfterTransformations(s: String, t: Int): Int {
            val modulo = 1_000_000_007
            val countArray = LongArray(26)
            for (c in s) {
                countArray[c - 'a']++
            }
            repeat(t) {
                val copyCountArray = countArray.copyOf()
                for (i in 0 until 25) {
                    countArray[i + 1] = copyCountArray[i]
                }
                countArray[0] = copyCountArray[25]
                countArray[1] += copyCountArray[25]
                countArray[1] = countArray[1].rem(modulo)
            }
            return countArray.sum().rem(modulo).toInt()
        }
    }
}
