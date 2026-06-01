package me.bossm0n5t3r.leetcode.teemoAttacking

class TeemoAttacking {
    class Solution {
        fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
            var cnt = 0
            var start = -1
            var end = -1
            for (time in timeSeries) {
                if (end < time) {
                    cnt += (end - start + 1)
                    start = time
                }
                end = time + duration - 1
            }
            cnt += (end - start + 1)
            return cnt - 1
        }
    }
}
