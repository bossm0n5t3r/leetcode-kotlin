package me.bossm0n5t3r.leetcode.earliestfinishtimeforlandandwaterridesi

class EarliestFinishTimeForLandAndWaterRidesI {
    class Solution {
        fun earliestFinishTime(
            landStartTime: IntArray,
            landDuration: IntArray,
            waterStartTime: IntArray,
            waterDuration: IntArray,
        ): Int {
            val n = landStartTime.size
            val m = waterStartTime.size
            var result = Int.MAX_VALUE
            for (land in 0 until n) {
                for (water in 0 until m) {
                    val landToWater =
                        maxOf(landStartTime[land] + landDuration[land], waterStartTime[water]) +
                            waterDuration[water]
                    val waterToLand =
                        maxOf(waterStartTime[water] + waterDuration[water], landStartTime[land]) +
                            landDuration[land]
                    result = minOf(result, minOf(landToWater, waterToLand))
                }
            }
            return result
        }
    }
}
