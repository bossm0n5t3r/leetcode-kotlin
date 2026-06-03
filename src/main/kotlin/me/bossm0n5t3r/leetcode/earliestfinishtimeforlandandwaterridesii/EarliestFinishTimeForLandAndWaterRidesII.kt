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
            val firstRides = firstStart.toRides(firstDuration).sortedBy { it.finish }
            val secondRides = secondStart.toRides(secondDuration).sortedBy { it.start }
            val suffixMinFinish = buildSuffixMinFinish(secondRides)

            var result = Int.MAX_VALUE
            var minAvailableSecondDuration = Int.MAX_VALUE
            var secondIndex = 0

            for (firstRide in firstRides) {
                val firstFinish = firstRide.finish

                while (
                    secondIndex < secondRides.size && secondRides[secondIndex].start <= firstFinish
                ) {
                    minAvailableSecondDuration =
                        minOf(minAvailableSecondDuration, secondRides[secondIndex].duration)
                    secondIndex++
                }

                if (minAvailableSecondDuration != Int.MAX_VALUE) {
                    result = minOf(result, firstFinish + minAvailableSecondDuration)
                }
                result = minOf(result, suffixMinFinish[secondIndex])
            }

            return result
        }

        private fun buildSuffixMinFinish(rides: List<Ride>): IntArray {
            val suffixMinFinish = IntArray(rides.size + 1) { Int.MAX_VALUE }
            for (i in rides.lastIndex downTo 0) {
                suffixMinFinish[i] = minOf(rides[i].finish, suffixMinFinish[i + 1])
            }
            return suffixMinFinish
        }

        private fun IntArray.toRides(duration: IntArray): List<Ride> {
            return this.zip(duration) { start, duration -> Ride(start, duration) }
        }

        private data class Ride(val start: Int, val duration: Int) {
            val finish: Int
                get() = start + duration
        }
    }
}
