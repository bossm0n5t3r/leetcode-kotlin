package me.bossm0n5t3r.leetcode.cinemaseatallocation

class CinemaSeatAllocation {
    class Solution {
        fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
            val left = 0b11110000
            val middle = 0b11000011
            val right = 0b00001111
            val occupied = mutableMapOf<Int, Int>()
            for ((row, seat) in reservedSeats) {
                if (seat in 2..9) {
                    val origin: Int = occupied[row] ?: 0
                    val value = origin or (1 shl (seat - 2))
                    occupied[row] = value
                }
            }
            var result = (n - occupied.size) * 2
            for ((_, bitmask) in occupied) {
                if (
                    (bitmask or left) == left ||
                        (bitmask or middle) == middle ||
                        (bitmask or right) == right
                ) {
                    ++result
                }
            }
            return result
        }
    }
}
