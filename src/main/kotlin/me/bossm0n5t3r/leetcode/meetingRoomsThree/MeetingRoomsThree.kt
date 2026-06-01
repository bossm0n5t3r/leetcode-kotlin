package me.bossm0n5t3r.leetcode.meetingRoomsThree

import java.util.PriorityQueue

class MeetingRoomsThree {
    class Solution {
        fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
            val sortedMeetings = meetings.sortedBy { it[0] }
            val free = PriorityQueue<Int>().apply { this.addAll(0 until n) }
            val taken =
                PriorityQueue<Pair<Int, Int>> { a, b ->
                    if (a.first == b.first) a.second - b.second else a.first - b.first
                }
            val count = IntArray(n)

            for (meeting in sortedMeetings) {
                val (curStart, curEnd) = meeting
                while (taken.isNotEmpty() && taken.peek().first <= curStart) {
                    val (_, roomNo) = taken.poll()
                    free.offer(roomNo)
                }
                val roomNo =
                    if (free.isEmpty()) {
                        val (nextEnd, roomNo) = taken.poll()
                        taken.offer(nextEnd + curEnd - curStart to roomNo)
                        roomNo
                    } else {
                        val roomNo = free.poll()
                        taken.offer(curEnd to roomNo)
                        roomNo
                    }
                count[roomNo]++
            }

            return count.indexOf(count.maxOrNull() ?: 0)
        }
    }
}
