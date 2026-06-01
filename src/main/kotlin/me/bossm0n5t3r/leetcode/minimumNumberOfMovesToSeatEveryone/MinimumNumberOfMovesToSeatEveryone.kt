package me.bossm0n5t3r.leetcode.minimumNumberOfMovesToSeatEveryone

import kotlin.math.abs

class MinimumNumberOfMovesToSeatEveryone {
    class Solution {
        fun minMovesToSeat(seats: IntArray, students: IntArray): Int =
            seats.sorted().zip(students.sorted()).sumOf { abs(it.first - it.second) }
    }
}
