package me.bossm0n5t3r.leetcode.numberofwaystoreorderarraytogetsamebst

class NumberOfWaysToReorderArrayToGetSameBST {
    class Solution {
        fun numOfWays(nums: IntArray): Int {
            val mod = 1_000_000_007
            val n = nums.size

            // comb[i][j] = i개 중 j개를 선택하는 조합의 수
            val comb = Array(n + 1) { IntArray(n + 1) }

            // 파스칼의 삼각형으로 조합 미리 계산
            for (i in 0..n) {
                comb[i][0] = 1
                comb[i][i] = 1

                for (j in 1..(i - 1)) {
                    comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % mod
                }
            }

            fun dfs(arr: List<Int>): Int {
                // 원소가 0~2개면 같은 BST를 만드는 순서는 1가지
                if (arr.size <= 2) return 1
                val root = arr[0]

                val left = mutableListOf<Int>()
                val right = mutableListOf<Int>()

                // 루트를 제외한 숫자들을 두 서브트리로 분리
                for (i in 1 until arr.size) {
                    val num = arr[i]
                    if (num < root) left += num else right += num
                }

                // 각 서브트리를 동일한 BST로 만드는 경우의 수
                val leftWays = dfs(left)
                val rightWays = dfs(right)

                // 두 서브트리의 내부 순서를 유지하면서
                // 왼쪽 L개와 오른쪽 R개를 섞는 경우의 수
                val lSize = left.size
                val rSize = right.size

                val mergeWays = comb[lSize + rSize][lSize]

                // 왼쪽 경우의 수 × 오른쪽 경우의 수 × 섞는 경우의 수
                val ways = mergeWays.toLong() * leftWays % mod
                return (ways * rightWays % mod).toInt()
            }

            val totalWays = dfs(nums.toList())

            // 원래 배열 자체는 제외
            return (totalWays - 1 + mod) % mod
        }
    }
}
