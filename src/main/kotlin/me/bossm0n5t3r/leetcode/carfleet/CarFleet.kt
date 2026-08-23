package me.bossm0n5t3r.leetcode.carfleet

class CarFleet {
    class Solution {
        fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
            val n = position.size
            val arrivalTimes = DoubleArray(target)
            for (i in 0 until n) {
                arrivalTimes[position[i]] = (target - position[i]).toDouble() / speed[i]
            }
            var result = 0
            var prev = 0.0
            for (i in target - 1 downTo 0) {
                val cur = arrivalTimes[i]
                if (cur > prev) {
                    result++
                    prev = cur
                }
            }
            return result
        }
    }
}
