package me.bossm0n5t3r.leetcode.anglebetweenhandsofaclock

class AngleBetweenHandsOfAClock {
    class Solution {
        fun angleClock(hour: Int, minutes: Int): Double {
            val minutesDegreeFromZero = minutes * 6.0
            val hourDegreeFromZero = (hour % 12) * 30.0 + (minutes / 60.0) * 30.0
            val result = abs(hourDegreeFromZero - minutesDegreeFromZero) % 360
            return minOf(result, 360 - result)
        }

        private fun abs(n: Double) = if (n >= 0.0) n else -n
    }
}
