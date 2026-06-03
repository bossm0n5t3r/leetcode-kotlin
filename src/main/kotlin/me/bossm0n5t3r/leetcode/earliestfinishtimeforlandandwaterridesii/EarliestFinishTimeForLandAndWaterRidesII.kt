package me.bossm0n5t3r.leetcode.earliestfinishtimeforlandandwaterridesii

class EarliestFinishTimeForLandAndWaterRidesII {
    class Solution {
        fun earliestFinishTime(
            landStartTime: IntArray,
            landDuration: IntArray,
            waterStartTime: IntArray,
            waterDuration: IntArray,
        ): Int {
            return minOf(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration),
            )
        }

        private fun solve(
            firstStart: IntArray,
            firstDuration: IntArray,
            secondStart: IntArray,
            secondDuration: IntArray,
        ): Int {
            val firstData =
                firstStart.zip(firstDuration).sortedWith(compareBy { it.first + it.second })
            val secondData = secondStart.zip(secondDuration).sortedWith(compareBy { it.first })

            val n = secondData.size
            val suffixMinFinish = IntArray(n + 1) { Int.MAX_VALUE }
            for (i in n - 1 downTo 0) {
                val finish = secondData[i].first + secondData[i].second
                suffixMinFinish[i] = minOf(finish, suffixMinFinish[i + 1])
            }

            var result = Int.MAX_VALUE
            var minDuration = Int.MAX_VALUE
            var secondIndex = 0

            for ((fStart, fDuration) in firstData) {
                val firstFinish = fStart + fDuration

                while (secondIndex < n && secondData[secondIndex].first <= firstFinish) {
                    minDuration = minOf(minDuration, secondData[secondIndex].second)
                    secondIndex++
                }

                if (minDuration != Int.MAX_VALUE) {
                    result = minOf(result, firstFinish + minDuration)
                }
                result = minOf(result, suffixMinFinish[secondIndex])
            }

            return result
        }
    }
}
