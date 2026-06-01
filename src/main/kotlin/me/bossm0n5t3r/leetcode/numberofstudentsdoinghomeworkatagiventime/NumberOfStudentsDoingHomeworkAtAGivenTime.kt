package me.bossm0n5t3r.leetcode.numberofstudentsdoinghomeworkatagiventime

class NumberOfStudentsDoingHomeworkAtAGivenTime {
    class Solution {
        fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
            var count = 0
            for (i in startTime.indices) {
                if (queryTime >= startTime[i] && queryTime <= endTime[i]) count++
            }
            return count
        }
    }
}
