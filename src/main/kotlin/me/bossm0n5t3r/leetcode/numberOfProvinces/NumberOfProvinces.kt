package me.bossm0n5t3r.leetcode.numberOfProvinces

import java.util.Stack

class NumberOfProvinces {
    class Solution {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val n = isConnected.size
            val visited = Array(n) { BooleanArray(n) { false } }
            val nRange = 0 until n
            var result = 0
            for (r in nRange) {
                for (c in nRange) {
                    if (visited[r][c].not() && isConnected[r][c] == 1) {
                        result++
                        dfs(isConnected, visited, r, c)
                    }
                }
            }
            return result
        }

        private fun dfs(
            isConnected: Array<IntArray>,
            visited: Array<BooleanArray>,
            r: Int,
            c: Int,
        ) {
            val n = isConnected.size
            val stack = Stack<Pair<Int, Int>>().apply { this.push(r to c) }
            visited[r][c] = true
            visited[c][r] = true
            while (stack.isNotEmpty()) {
                val (curR, curC) = stack.pop()
                for (nc in 0 until n) {
                    if (isConnected[curR][nc] == 1 && visited[curR][nc].not()) {
                        visited[curR][nc] = true
                        stack.push(curR to nc)
                    }
                }
                for (nr in 0 until n) {
                    if (isConnected[nr][curC] == 1 && visited[nr][curC].not()) {
                        visited[nr][curC] = true
                        stack.push(nr to curC)
                    }
                }
            }
        }
    }
}
