package me.bossm0n5t3r.leetcode.stonegamev

class StoneGameV {
    class Solution {
        fun stoneGameV(stoneValue: IntArray): Int {
            val n = stoneValue.size
            val f = Array(n) { IntArray(n) }
            return dfs(stoneValue, 0, n - 1, f)
        }

        private fun dfs(stoneValue: IntArray, left: Int, right: Int, f: Array<IntArray>): Int {
            if (left == right) return 0
            if (f[left][right] != 0) return f[left][right]

            var sum = 0
            for (i in left..right) {
                sum += stoneValue[i]
            }
            var sumL = 0
            for (i in left until right) {
                sumL += stoneValue[i]
                val sumR = sum - sumL
                f[left][right] =
                    when {
                        sumL < sumR -> maxOf(f[left][right], dfs(stoneValue, left, i, f) + sumL)
                        sumL > sumR ->
                            maxOf(f[left][right], dfs(stoneValue, i + 1, right, f) + sumR)
                        else ->
                            maxOf(
                                f[left][right],
                                maxOf(
                                    dfs(stoneValue, left, i, f),
                                    dfs(stoneValue, i + 1, right, f),
                                ) + sumL,
                            )
                    }
            }
            return f[left][right]
        }
    }
}
