package me.bossm0n5t3r.leetcode.beautifulArrangement2

class BeautifulArrangement2 {
    class Solution {
        fun constructArray(n: Int, k: Int): IntArray {
            val result = IntArray(n) { 0 }
            val sign = (k % 2) == 1
            var start = 1
            var startCount = if (sign) n - (k / 2) else k / 2
            var end = n
            var endCount = n - startCount
            var idx = 0
            while (idx < n) {
                if (startCount == 0) {
                    while (endCount-- > 0) {
                        result[idx++] = end--
                    }
                    break
                }
                if (endCount == 0) {
                    while (startCount-- > 0) {
                        result[idx++] = start++
                    }
                    break
                }
                result[idx] =
                    if (idx % 2 == 0) {
                        startCount--
                        start++
                    } else {
                        endCount--
                        end--
                    }
                idx++
            }
            return result
        }

        fun constructArraySolution(n: Int, k: Int): IntArray {
            val result = IntArray(n) { 0 }
            var idx = 0
            (1 until n - k).forEach { result[idx++] = it }
            (0..k).forEach {
                result[idx++] =
                    if (it % 2 == 0) {
                        n - k + it / 2
                    } else {
                        n - it / 2
                    }
            }
            return result
        }
    }
}
