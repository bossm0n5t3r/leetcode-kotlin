package me.bossm0n5t3r.leetcode.minimumOperationsToWriteTheLetterYOnAGrid

class MinimumOperationsToWriteTheLetterYOnAGrid {
    class Solution {
        private class GridAria(
            private val onY: IntArray,
            private val leftY: IntArray,
            private val upperY: IntArray,
            private val rightY: IntArray,
        ) {
            fun needCountToConvertForEachInY(): IntArray {
                val total = this.onY.sum()
                return this.onY.map { total - it }.toIntArray()
            }

            fun needCountToConvertForEachOutY(): IntArray {
                val eachTotal =
                    listOf(
                        this.leftY[0] + this.upperY[0] + this.rightY[0],
                        this.leftY[1] + this.upperY[1] + this.rightY[1],
                        this.leftY[2] + this.upperY[2] + this.rightY[2],
                    )
                val total = eachTotal.sum()
                return eachTotal.map { total - it }.toIntArray()
            }
        }

        fun minimumOperationsToWriteY(grid: Array<IntArray>): Int {
            val gridAria = grid.toAria()
            val needCountToConvertForEachInY = gridAria.needCountToConvertForEachInY()
            val needCountToConvertForEachOutY = gridAria.needCountToConvertForEachOutY()

            var result = Int.MAX_VALUE
            for (i in 0..2) {
                result =
                    minOf(
                        result,
                        needCountToConvertForEachInY[i] +
                            minOf(
                                needCountToConvertForEachOutY[(i + 1) % 3],
                                needCountToConvertForEachOutY[(i + 2) % 3],
                            ),
                    )
            }

            return result
        }

        private fun Array<IntArray>.toAria(): GridAria {
            val onY = IntArray(3) { 0 }
            val leftY = IntArray(3) { 0 }
            val upperY = IntArray(3) { 0 }
            val rightY = IntArray(3) { 0 }

            val n = this.size
            val mid = n / 2

            for (r in 0 until n) {
                for (c in 0 until n) {
                    val cur = this[r][c]
                    when {
                        // The diagonal starting at the top-left cell and ending at the center cell of the grid.
                        r == c && r < mid -> onY[cur]++

                        // The diagonal starting at the top-right cell and ending at the center cell of the grid.
                        r == n - 1 - c && r < mid -> onY[cur]++

                        // The vertical line starting at the center cell and ending at the bottom border of the grid.
                        r >= mid && c == mid -> onY[cur]++

                        r < mid && (r < c && c < n - 1 - r) -> upperY[cur]++

                        c < mid -> leftY[cur]++

                        else -> rightY[cur]++
                    }
                }
            }

            return GridAria(onY, leftY, upperY, rightY)
        }
    }
}
