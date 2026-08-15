package me.bossm0n5t3r.leetcode.numberofelapsedsecondsbetweentwotimes

class NumberOfElapsedSecondsBetweenTwoTimes {
    class Solution {
        fun secondsBetweenTimes(startTime: String, endTime: String): Int {
            return endTime.toSeconds() - startTime.toSeconds()
        }

        private fun String.toSeconds(): Int {
            return this.split(":")
                .map { it.toInt() }
                .let {
                    val (hour, minute, second) = it
                    hour * 60 * 60 + minute * 60 + second
                }
        }
    }
}
