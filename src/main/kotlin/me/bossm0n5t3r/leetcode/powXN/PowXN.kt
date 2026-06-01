package me.bossm0n5t3r.leetcode.powXN

class PowXN {
    class Solution {
        fun myPow(x: Double, n: Int): Double {
            var varX = x
            var varN = n
            if (varN < 0) {
                varN = -n
                varX = 1 / x
            }

            var pow = 1.0

            while (varN != 0) {
                if ((varN and 1) != 0) {
                    pow *= varX
                }

                varX *= varX
                varN = varN ushr 1
            }

            return pow
        }
    }
}
