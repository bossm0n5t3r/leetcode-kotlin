package me.bossm0n5t3r.leetcode.sqrtX

class SqrtX {
    class Solution {
        fun mySqrtFirst(x: Int): Int {
            if (x == 0) return 0
            if (x <= 3) return 1
            var result = 1
            while (result <= x / result) {
                result++
            }
            return result - 1
        }

        fun mySqrtSecond(x: Int): Int {
            if (x == 0) return 0
            if (x <= 3) return 1
            var left = 2
            var right = x / 2
            while (left <= right) {
                val mid = left + (right - left) / 2
                val remainder = x / mid
                when {
                    mid > remainder -> {
                        right = mid - 1
                    }

                    mid < remainder -> {
                        left = mid + 1
                    }

                    else -> {
                        return mid
                    }
                }
            }
            return right
        }
    }
}
