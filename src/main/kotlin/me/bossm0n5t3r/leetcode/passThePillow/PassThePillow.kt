package me.bossm0n5t3r.leetcode.passThePillow

class PassThePillow {
    class Solution {
        fun passThePillow(n: Int, time: Int): Int =
            if (time / (n - 1) % 2 == 0) (time % (n - 1) + 1) else (n - time % (n - 1))
    }
}
