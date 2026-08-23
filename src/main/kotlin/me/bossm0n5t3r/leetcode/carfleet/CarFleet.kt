package me.bossm0n5t3r.leetcode.carfleet

class CarFleet {
    class Solution {
        fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
            val n = position.size
            val arrivalTimes =
                position
                    .zip(speed)
                    .sortedBy { it.first }
                    .map { (p, s) -> (target - p).toDouble() / s }
            var result = 0
            var index = n - 1
            while (index >= 0) {
                val cur = arrivalTimes[index--]
                while (index >= 0 && arrivalTimes[index] <= cur) {
                    index--
                }
                result++
            }
            return result
        }
    }
}
