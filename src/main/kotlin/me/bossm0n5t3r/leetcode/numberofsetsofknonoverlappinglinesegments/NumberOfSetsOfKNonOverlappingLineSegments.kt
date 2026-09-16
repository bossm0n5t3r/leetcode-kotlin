package me.bossm0n5t3r.leetcode.numberofsetsofknonoverlappinglinesegments

class NumberOfSetsOfKNonOverlappingLineSegments {
    class Solution {
        fun numberOfSets(n: Int, k: Int): Int {
            val modulo = 1_000_000_007

            // dp[i][j] = 앞에서 i개의 점을 봤을 때 j개의 선분을 완성한 경우의 수
            val dp = Array(n + 1) { IntArray(k + 1) }
            dp[0][0] = 1

            // open[i][j] = 앞에서 i개의 점을 봤을 때 j개의 선분을 완성했고, 현재 하나의 선분이 열려 있는 경우의 수
            val open = Array(n + 1) { IntArray(k + 1) }

            for (i in 0 until n) {
                for (j in 0..k) {
                    // 현재 점을 아무것도 안 하고 넘김
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j]) % modulo

                    // 현재 점에서 새 선분 시작
                    open[i + 1][j] = (open[i + 1][j] + dp[i][j]) % modulo

                    // 이미 열려 있는 선분을 계속 유지
                    open[i + 1][j] = (open[i + 1][j] + open[i][j]) % modulo

                    // 현재 점에서 열린 선분을 닫음
                    if (j + 1 <= k) {
                        dp[i + 1][j + 1] = (dp[i + 1][j + 1] + open[i][j]) % modulo
                    }

                    // endpoint 공유 허용:
                    // 현재 점에서 기존 선분을 닫고,
                    // 동시에 다음 선분을 다시 시작할 수도 있음
                    if (j + 1 <= k) {
                        open[i + 1][j + 1] = (open[i + 1][j + 1] + open[i][j]) % modulo
                    }
                }
            }

            return dp[n][k]
        }

        fun numberOfSetsByCombination(n: Int, k: Int): Int {
            val modulo = 1_000_000_007L
            val total = n + k - 1
            val select = 2 * k

            if (select > total) return 0

            val factorial = LongArray(total + 1)
            factorial[0] = 1L

            for (i in 1..total) {
                factorial[i] = factorial[i - 1] * i % modulo
            }

            val denominator = factorial[select] * factorial[total - select] % modulo

            val denominatorInverse = modPow(denominator, modulo - 2, modulo)

            return (factorial[total] * denominatorInverse % modulo).toInt()
        }

        private fun modPow(base: Long, exponent: Long, modulo: Long): Long {
            var base = base
            var exponent = exponent
            var result = 1L

            while (exponent > 0) {
                if (exponent % 2 == 1L) {
                    result = result * base % modulo
                }

                base = base * base % modulo
                exponent /= 2
            }

            return result
        }
    }
}
