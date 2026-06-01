package me.bossm0n5t3r.leetcode.triangle

import kotlin.math.min

class Triangle {
    class Solution {
        fun minimumTotalAt20250104(triangle: List<List<Int>>): Int {
            if (triangle.size == 1) return triangle[0][0]
            val dp = IntArray(triangle.size) { triangle[triangle.size - 1][it] }

            for (i in triangle.size - 2 downTo 0) {
                for (j in 0..i) {
                    dp[j] = triangle[i][j] + minOf(dp[j], dp[j + 1])
                }
            }

            return dp[0]
        }

        fun minimumTotal(triangle: List<List<Int>>): Int {
            val n = triangle.size
            val cache = IntArray(n) { 0 }
            cache[0] = triangle.first().first()
            (1 until n).forEach { i ->
                (i downTo 0).forEach { j ->
                    cache[j] =
                        when (j) {
                            i -> {
                                cache[j - 1]
                            }

                            0 -> {
                                cache[j]
                            }

                            else -> {
                                min(cache[j - 1], cache[j])
                            }
                        } + triangle[i][j]
                }
            }
            return cache.minOrNull() ?: -1
        }
    }
}
