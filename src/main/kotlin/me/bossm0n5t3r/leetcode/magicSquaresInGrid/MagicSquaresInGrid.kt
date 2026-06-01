package me.bossm0n5t3r.leetcode.magicSquaresInGrid

class MagicSquaresInGrid {
    class Solution {
        fun numMagicSquaresInside(grid: Array<IntArray>): Int =
            grid.toListOfIntList().validateOrNull()?.countMagicSquares() ?: 0

        private fun Array<IntArray>.toListOfIntList(): List<List<Int>> = this.map { it.toList() }

        private fun List<List<Int>>.validateOrNull(): List<List<Int>>? {
            val (m, n) = this.size to this.firstOrNull()?.size
            return this.takeIf { m >= 3 && n != null && n >= 3 }
        }

        private fun List<List<Int>>.countMagicSquares(): Int {
            val (m, n) = this.size to this.first().size
            var count = 0
            for (r in 0..m - 3) {
                for (c in 0..n - 3) {
                    if (isMagicSquare(this, r, c)) {
                        count++
                    }
                }
            }
            return count
        }

        private fun isMagicSquare(grid: List<List<Int>>, curR: Int, curC: Int): Boolean {
            val square = grid.subList(curR, curR + 3).map { it.subList(curC, curC + 3) }

            val allElements = square.flatten().sorted()
            if (allElements != (1..9).toList()) return false

            val sumOfRows = setOf(square[0].sum(), square[1].sum(), square[2].sum())
            if (sumOfRows.size > 1) return false

            val sumOfCols =
                setOf(
                    square[0][0] + square[1][0] + square[2][0],
                    square[0][1] + square[1][1] + square[2][1],
                    square[0][2] + square[1][2] + square[2][2],
                )
            if (sumOfCols.size > 1) return false

            val sumOfDiagonals =
                setOf(
                    square[0][0] + square[1][1] + square[2][2],
                    square[0][2] + square[1][1] + square[2][0],
                )
            if (sumOfDiagonals.size > 1) return false

            val allSums = setOf(sumOfRows.first(), sumOfCols.first(), sumOfDiagonals.first())
            return allSums.size == 1
        }
    }
}
