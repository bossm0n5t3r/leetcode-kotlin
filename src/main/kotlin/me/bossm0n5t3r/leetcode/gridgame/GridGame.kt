package me.bossm0n5t3r.leetcode.gridgame

class GridGame {
    class Solution {
        private fun IntArray.toPrefixSum(): LongArray =
            this.runningFold(0L) { acc: Long, i: Int -> acc + i }.toLongArray()

        fun gridGame(grid: Array<IntArray>): Long {
            val n = grid.first().size
            val firstRowPrefixSum = grid.first().toPrefixSum()
            val secondRowPrefixSum = grid.last().toPrefixSum()

            val downIndex =
                (1..n).minBy {
                    maxOf(
                        firstRowPrefixSum.last() - firstRowPrefixSum[it],
                        secondRowPrefixSum[it - 1],
                    )
                } - 1

            for (i in 0 until n) {
                when {
                    i < downIndex -> {
                        grid.first()[i] = 0
                    }

                    i > downIndex -> {
                        grid.last()[i] = 0
                    }

                    else -> {
                        grid.first()[i] = 0
                        grid.last()[i] = 0
                    }
                }
            }

            val modifiedFirstRowPrefixSum = grid.first().toPrefixSum()
            val modifiedSecondRowPrefixSum = grid.last().toPrefixSum()

            return (1..n).maxOf {
                modifiedFirstRowPrefixSum[it] + modifiedSecondRowPrefixSum.last() -
                    modifiedSecondRowPrefixSum[it - 1]
            }
        }
    }
}
