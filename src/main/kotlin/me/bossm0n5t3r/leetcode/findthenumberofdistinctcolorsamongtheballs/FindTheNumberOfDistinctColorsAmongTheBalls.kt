package me.bossm0n5t3r.leetcode.findthenumberofdistinctcolorsamongtheballs

class FindTheNumberOfDistinctColorsAmongTheBalls {
    class Solution {
        fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
            val ballToColor = mutableMapOf<Int, Int>()
            val colorsToBallCount = mutableMapOf<Int, Int>()
            val result = IntArray(queries.size) { 0 }
            for (i in queries.indices) {
                val (x, y) = queries[i]
                val previousColor = ballToColor[x] ?: -1
                if (previousColor > 0) {
                    val previousBallCount = colorsToBallCount.getOrDefault(previousColor, 0)
                    if (previousBallCount == 1) {
                        colorsToBallCount.remove(previousColor)
                    } else {
                        colorsToBallCount[previousColor] = previousBallCount - 1
                    }
                }
                ballToColor[x] = y
                colorsToBallCount[y] = colorsToBallCount.getOrDefault(y, 0) + 1
                result[i] = colorsToBallCount.keys.size
            }
            return result
        }
    }
}
