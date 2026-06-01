package me.bossm0n5t3r.leetcode.sudokuSolver

class SudokuSolver {
    class Solution {
        fun solveSudoku(board: Array<CharArray>) {
            val sudokuWrapper = SudokuWrapper(result = Array(9) { CharArray(9) { '.' } })
            dfs(board, 0, sudokuWrapper)
            (0 until 9).forEach { r ->
                (0 until 9).forEach { c -> board[r][c] = sudokuWrapper.result[r][c] }
            }
        }

        private data class SudokuWrapper(val result: Array<CharArray>) {
            override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as SudokuWrapper

                if (!result.contentDeepEquals(other.result)) return false

                return true
            }

            override fun hashCode(): Int = result.contentDeepHashCode()
        }

        private fun dfs(board: Array<CharArray>, cur: Int, sudokuWrapper: SudokuWrapper) {
            if (cur == 81) {
                if (!isValid(sudokuWrapper.result) && isValid(board)) {
                    (0 until 9).forEach { r ->
                        (0 until 9).forEach { c -> sudokuWrapper.result[r][c] = board[r][c] }
                    }
                }
                return
            }
            val r = cur / 9
            val c = cur % 9
            if (board[r][c] != '.') {
                dfs(board, cur + 1, sudokuWrapper)
                return
            }
            val candidates = getCandidates(board, r, c)
            val tmp = board[r][c]
            candidates.forEach { candidate ->
                board[r][c] = candidate
                dfs(board, cur + 1, sudokuWrapper)
            }
            board[r][c] = tmp
        }

        private fun getCandidates(board: Array<CharArray>, r: Int, c: Int): Set<Char> {
            if (board[r][c] != '.') return emptySet()
            val result = ('1'..'9').toMutableSet()
            (0 until 9).forEach { i ->
                if (i != c && board[r][i] != '.') {
                    result.remove(board[r][i])
                }
                if (i != r && board[i][c] != '.') {
                    result.remove(board[i][c])
                }
            }
            val tmpR = (r / 3) * 3
            val tmpC = (c / 3) * 3
            (tmpR until tmpR + 3).forEach { insideR ->
                (tmpC until tmpC + 3).forEach { insideC ->
                    val tmpChar = board[insideR][insideC]
                    if (tmpChar != '.' && result.contains(tmpChar)) {
                        result.remove(tmpChar)
                    }
                }
            }
            return result
        }

        fun isValid(board: Array<CharArray>): Boolean {
            board.forEachIndexed { index, chars ->
                if (chars.contains('.')) return false
                val row = chars.map { c -> c.toString().toInt() }
                if (row.sum() < 45) return false
                if (index % 3 == 0) {
                    (0 until 3).forEach { tmpC ->
                        val tmp =
                            listOf(
                                    board[index][tmpC * 3],
                                    board[index][tmpC * 3 + 1],
                                    board[index][tmpC * 3 + 2],
                                    board[index + 1][tmpC * 3],
                                    board[index + 1][tmpC * 3 + 1],
                                    board[index + 1][tmpC * 3 + 2],
                                    board[index + 2][tmpC * 3],
                                    board[index + 2][tmpC * 3 + 1],
                                    board[index + 2][tmpC * 3 + 2],
                                )
                                .filter { it != '.' }
                                .map { it.toString().toInt() }
                        if (tmp.sum() < 45) return false
                    }
                }
            }
            (0 until 9).forEach { c ->
                val column =
                    listOf(
                            board[0][c],
                            board[1][c],
                            board[2][c],
                            board[3][c],
                            board[4][c],
                            board[5][c],
                            board[6][c],
                            board[7][c],
                            board[8][c],
                        )
                        .filter { it != '.' }
                        .map { it.toString().toInt() }
                if (column.sum() < 45) return false
            }
            return true
        }
    }
}
