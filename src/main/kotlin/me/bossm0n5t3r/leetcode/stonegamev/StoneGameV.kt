package me.bossm0n5t3r.leetcode.stonegamev

class StoneGameV {
    class Solution {
        fun stoneGameV(stoneValue: IntArray): Int {
            val n = stoneValue.size
            val pre = IntArray(n + 1)

            stoneValue.forEachIndexed { i, x -> pre[i + 1] = pre[i] + x }

            val memo = Array(n) { IntArray(n + 1) { -1 } }

            fun dp(l: Int, r: Int): Int {
                if (r - l < 2) return 0
                if (memo[l][r] != -1) return memo[l][r]

                val total = pre[r] - pre[l]
                var ans = 0

                for (m in l + 1 until r) {
                    val left = pre[m] - pre[l]
                    val right = total - left

                    val cur =
                        when {
                            left < right -> left + dp(l, m)
                            left > right -> right + dp(m, r)
                            else -> left + maxOf(dp(l, m), dp(m, r))
                        }

                    ans = maxOf(ans, cur)
                }

                return ans.also { memo[l][r] = it }
            }

            return dp(0, n)
        }
    }
}
