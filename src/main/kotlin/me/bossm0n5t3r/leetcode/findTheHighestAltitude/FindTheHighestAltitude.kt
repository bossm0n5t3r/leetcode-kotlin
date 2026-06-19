package me.bossm0n5t3r.leetcode.findTheHighestAltitude

class FindTheHighestAltitude {
    class Solution {
        fun largestAltitude(gain: IntArray): Int {
            var tmp = 0
            var highest = 0
            for (diff in gain) {
                tmp += diff
                if (tmp > highest) highest = tmp
            }
            return highest
        }
    }
}
