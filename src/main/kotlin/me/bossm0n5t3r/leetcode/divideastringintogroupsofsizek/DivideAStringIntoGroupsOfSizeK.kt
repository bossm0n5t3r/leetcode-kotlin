package me.bossm0n5t3r.leetcode.divideastringintogroupsofsizek

class DivideAStringIntoGroupsOfSizeK {
    class Solution {
        fun divideString(s: String, k: Int, fill: Char): Array<String> =
            s.let {
                    val desiredLength = (((it.length - 1) / k) + 1) * k
                    it.padEnd(desiredLength, fill)
                }
                .chunked(k)
                .toTypedArray()
    }
}
