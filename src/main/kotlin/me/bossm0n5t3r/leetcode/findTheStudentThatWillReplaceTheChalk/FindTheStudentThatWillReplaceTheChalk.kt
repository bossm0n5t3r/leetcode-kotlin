package me.bossm0n5t3r.leetcode.findTheStudentThatWillReplaceTheChalk

class FindTheStudentThatWillReplaceTheChalk {
    class Solution {
        fun chalkReplacer(chalk: IntArray, k: Int): Int {
            var remainder = k.toLong() % chalk.sumOf { it.toLong() }
            for ((index, chalkForStudent) in chalk.withIndex()) {
                if (chalkForStudent > remainder) {
                    return index
                }
                remainder -= chalkForStudent
            }
            return -1
        }
    }
}
