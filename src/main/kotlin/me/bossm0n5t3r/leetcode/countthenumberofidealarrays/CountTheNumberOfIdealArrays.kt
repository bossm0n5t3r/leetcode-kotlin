package me.bossm0n5t3r.leetcode.countthenumberofidealarrays

class CountTheNumberOfIdealArrays {
    class Solution {
        fun idealArrays(n: Int, maxValue: Int): Int {
            val modulo = 1_000_000_007
            val dp = Array(15) { LongArray(maxValue + 1) }
            val combinations = Array(n + 1) { LongArray(15) }

            // 초기화: 모든 숫자는 길이 1의 배열로 가능
            for (i in 1..maxValue) {
                dp[0][i] = 1
            }

            // 파스칼의 삼각형을 이용한 조합 계산
            combinations[0][0] = 1
            for (i in 1..n) {
                combinations[i][0] = 1
                for (j in 1..14) {
                    combinations[i][j] =
                        (combinations[i - 1][j - 1] + combinations[i - 1][j]) % modulo
                }
            }

            // 동적 프로그래밍으로 각 길이별 가능한 배열 계산
            for (len in 1..14) {
                for (num in 1..maxValue) {
                    var multiple = num * 2
                    while (multiple <= maxValue) {
                        dp[len][multiple] = (dp[len][multiple] + dp[len - 1][num]) % modulo
                        multiple += num
                    }
                }
            }

            var result = 0L
            // 최종 결과 계산
            for (i in 1..maxValue) {
                var sum = 0L
                for (j in 0..14) {
                    sum = (sum + (dp[j][i] * combinations[n - 1][j]) % modulo) % modulo
                }
                result = (result + sum) % modulo
            }

            return result.toInt()
        }
    }
}
