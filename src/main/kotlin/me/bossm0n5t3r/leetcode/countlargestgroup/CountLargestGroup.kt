package me.bossm0n5t3r.leetcode.countlargestgroup

class CountLargestGroup {
    class Solution {
        fun countLargestGroup(n: Int): Int =
            (1..n)
                .groupingBy { it.toDigitsSum() }
                .eachCount()
                .let {
                    val maxCount = it.maxOf { (_, value) -> value }
                    it.filter { (_, value) -> value == maxCount }
                }
                .count()

        private fun Int.toDigitsSum(): Int = this.toString().sumOf { it.digitToInt() }
    }
}
