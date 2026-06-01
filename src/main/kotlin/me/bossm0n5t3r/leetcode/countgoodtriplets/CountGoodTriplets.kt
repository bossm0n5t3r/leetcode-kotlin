package me.bossm0n5t3r.leetcode.countgoodtriplets

class CountGoodTriplets {
    class Solution {
        fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
            var count = 0
            val n = arr.size
            for (i in 0 until n - 2) {
                val curI = arr[i]
                for (j in i + 1 until n - 1) {
                    val curJ = arr[j]
                    if (abs(curI, curJ) > a) continue
                    for (k in j + 1 until n) {
                        val curK = arr[k]
                        if (abs(curJ, curK) > b) continue
                        if (abs(curI, curK) > c) continue
                        count++
                    }
                }
            }
            return count
        }

        private fun abs(a: Int, b: Int): Int = if (a >= b) a - b else b - a
    }
}
