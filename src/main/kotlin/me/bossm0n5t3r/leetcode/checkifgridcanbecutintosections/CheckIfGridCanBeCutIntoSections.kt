package me.bossm0n5t3r.leetcode.checkifgridcanbecutintosections

class CheckIfGridCanBeCutIntoSections {
    class Solution {
        fun checkValidCuts(n: Int, rectangles: Array<IntArray>): Boolean {
            val xRanges = mutableListOf<Pair<Int, Int>>()
            val yRanges = mutableListOf<Pair<Int, Int>>()
            for (rectangle in rectangles) {
                val (x1, y1, x2, y2) = rectangle
                xRanges.add(x1 to x2)
                yRanges.add(y1 to y2)
            }
            return xRanges.isValidCut() || yRanges.isValidCut()
        }

        private fun List<Pair<Int, Int>>.isValidCut(): Boolean {
            val rangeMap = mutableMapOf<Int, Int>()
            for ((start, end) in this) {
                rangeMap[start] = maxOf(rangeMap.getOrDefault(start, 0), end)
            }
            val sortedRanges = rangeMap.toList().sortedBy { it.first }
            val mergedRanges = mutableListOf<Pair<Int, Int>>()
            var index = 0
            while (index < sortedRanges.size) {
                val (start, end) = sortedRanges[index]
                var maxEnd = end
                while (index + 1 < sortedRanges.size && sortedRanges[index + 1].first < maxEnd) {
                    maxEnd = maxOf(maxEnd, sortedRanges[index + 1].second)
                    index++
                }
                mergedRanges.add(start to maxEnd)
                index++
            }
            return mergedRanges.size >= 3
        }
    }
}
