package me.bossm0n5t3r.leetcode.checkifthereisavalidparenthesesstringpath

class CheckIfThereIsAValidParenthesesStringPath {
    class Solution {
        private data class Cell(val r: Int, val c: Int, val balance: Int)

        private fun Char.toNumber() = if (this == '(') 1 else -1

        private val dr = intArrayOf(0, 1)
        private val dc = intArrayOf(1, 0)

        fun hasValidPath(grid: Array<CharArray>): Boolean {
            val m = grid.size
            val n = grid[0].size

            if (grid[0][0] == ')') return false

            val queue = ArrayDeque<Cell>()
            val visited = Array(m) { Array(n) { BooleanArray(m + n) } }

            val startBalance = grid[0][0].toNumber()

            queue.addLast(Cell(0, 0, startBalance))
            visited[0][0][startBalance] = true

            while (queue.isNotEmpty()) {
                val (r, c, balance) = queue.removeFirst()

                if (r == m - 1 && c == n - 1 && balance == 0) {
                    return true
                }

                for (i in dr.indices) {
                    val nr = r + dr[i]
                    val nc = c + dc[i]

                    if (nr !in 0 until m || nc !in 0 until n) {
                        continue
                    }

                    val nBalance = balance + grid[nr][nc].toNumber()

                    if (nBalance < 0 || visited[nr][nc][nBalance]) {
                        continue
                    }

                    visited[nr][nc][nBalance] = true
                    queue.addLast(Cell(nr, nc, nBalance))
                }
            }

            return false
        }
    }
}
