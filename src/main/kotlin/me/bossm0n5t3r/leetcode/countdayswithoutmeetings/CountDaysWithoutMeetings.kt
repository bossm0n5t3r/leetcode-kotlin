package me.bossm0n5t3r.leetcode.countdayswithoutmeetings

class CountDaysWithoutMeetings {
    class Solution {
        fun countDays(days: Int, meetings: Array<IntArray>): Int =
            days - meetings.toSortedMeetings().sumOf { it.second - it.first + 1 }

        private fun Array<IntArray>.toSortedMeetings(): List<Pair<Int, Int>> {
            val meetingMap = mutableMapOf<Int, Int>()
            for ((from, to) in this) {
                meetingMap[from] = maxOf(meetingMap.getOrDefault(from, 0), to)
            }
            val sortedMeetings = meetingMap.toList().sortedBy { it.first }
            val result = mutableListOf<Pair<Int, Int>>()
            var index = 0
            while (index < sortedMeetings.size) {
                var (from, to) = sortedMeetings[index]
                while (index + 1 < sortedMeetings.size && sortedMeetings[index + 1].first <= to) {
                    val next = sortedMeetings[index + 1]
                    from = minOf(from, next.first)
                    to = maxOf(to, next.second)
                    index++
                }
                result.add(from to to)
                index++
            }
            return result
        }
    }
}
