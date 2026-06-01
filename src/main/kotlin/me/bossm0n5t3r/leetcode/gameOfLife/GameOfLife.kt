package me.bossm0n5t3r.leetcode.gameOfLife

class GameOfLife {
    class Solution {
        fun gameOfLife(board: Array<IntArray>) {
            val m = board.size
            val n = board.first().size
            (0 until m).forEach { r ->
                (0 until n).forEach { c ->
                    val liveNeighborCells = checkLiveNeighbors(board, m, n, r, c)
                    if (liveNeighborCells == 3 || (board[r][c] == 1 && liveNeighborCells == 2)) {
                        board[r][c] = board[r][c] or 2
                    }
                }
            }
            (0 until m).forEach { r ->
                (0 until n).forEach { c -> board[r][c] = board[r][c] ushr 1 }
            }
        }

        private fun checkLiveNeighbors(
            board: Array<IntArray>,
            m: Int,
            n: Int,
            r: Int,
            c: Int,
        ): Int {
            var liveCells = 0
            val dr = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
            val dc = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
            (0..7).forEach { i ->
                val nr = r + dr[i]
                val nc = c + dc[i]
                if ((nr in 0 until m) && (nc in 0 until n)) {
                    liveCells += (board[nr][nc] and 1)
                }
            }
            return liveCells
        }

        data class Cell(val r: Int, val c: Int) {
            fun neighborCells(): List<Cell> {
                val dr = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
                val dc = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)
                return (0..7).map { i -> Cell(this.r + dr[i], this.c + dc[i]) }
            }
        }

        fun gameOfLifeInfinite(board: Array<IntArray>) {
            if (board.isEmpty() || board.first().isEmpty()) return

            val m = board.size
            val n = board.first().size
            val currentState = hashSetOf<Cell>()
            (0 until m).forEach { r ->
                (0 until n).forEach { c -> if (board[r][c] == 1) currentState.add(Cell(r, c)) }
            }

            val nextState = getNextState(currentState)
            (0 until m).forEach { r ->
                (0 until n).forEach { c ->
                    board[r][c] =
                        if (nextState.contains(Cell(r, c))) {
                            1
                        } else {
                            0
                        }
                }
            }
        }

        private fun getNextState(currentState: HashSet<Cell>): HashSet<Cell> {
            val nextState = hashSetOf<Cell>()
            if (currentState.isEmpty()) return nextState

            val cellToLiveNeighborCellCount = mutableMapOf<Cell, Int>()
            currentState.forEach { cell ->
                cell.neighborCells().forEach { neighborCell ->
                    cellToLiveNeighborCellCount[neighborCell] =
                        cellToLiveNeighborCellCount.getOrDefault(neighborCell, 0) + 1
                }
            }

            cellToLiveNeighborCellCount.forEach { (cell, liveNeighborCellCount) ->
                if (
                    liveNeighborCellCount == 3 ||
                        (liveNeighborCellCount == 2 && currentState.contains(cell))
                ) {
                    nextState.add(cell)
                }
            }

            return nextState
        }
    }
}
