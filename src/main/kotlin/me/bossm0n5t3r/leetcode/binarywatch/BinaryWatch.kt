package me.bossm0n5t3r.leetcode.binarywatch

class BinaryWatch {
    class Solution {
        private val hours: Map<Int, List<Int>>
        private val minutes: Map<Int, List<Int>>

        init {
            val tmpHours = mutableMapOf(0 to mutableListOf(0))
            for (hour in 1 until 12) {
                val countBits = hour.countOneBits()
                tmpHours[countBits] =
                    tmpHours.getOrDefault(countBits, mutableListOf()).apply { add(hour) }
            }
            hours = tmpHours

            val tmpMinutes = mutableMapOf(0 to mutableListOf(0))
            for (minute in 0..59) {
                val countBits = minute.countOneBits()
                tmpMinutes[countBits] =
                    tmpMinutes.getOrDefault(countBits, mutableListOf()).apply { add(minute) }
            }
            minutes = tmpMinutes
        }

        fun readBinaryWatch(turnedOn: Int): List<String> {
            val result = mutableSetOf<String>()
            for (hourCount in 0..turnedOn) {
                val minuteCount = turnedOn - hourCount
                val hourCandidates = hours[hourCount].orEmpty()
                val minuteCandidates = minutes[minuteCount].orEmpty()
                for (hour in hourCandidates) {
                    for (minute in minuteCandidates) {
                        result.add("$hour:${minute.toString().padStart(2, '0')}")
                    }
                }
            }
            return result.toList()
        }
    }
}
