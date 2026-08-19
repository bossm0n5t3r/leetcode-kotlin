package me.bossm0n5t3r.leetcode.cinemaseatallocation

class CinemaSeatAllocation {
    class Solution {
        fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
            val sortedReservedSeats =
                reservedSeats.sortedWith(
                    compareBy<IntArray> { it.first() }.thenComparing { it.last() }
                )
            var result = n * 2
            var curRow = 1
            val availableSeats = BooleanArray(3) { true }
            for ((row, seat) in sortedReservedSeats) {
                if (curRow != row) {
                    result -=
                        when {
                            availableSeats[0] && availableSeats[2] -> 0
                            availableSeats.none { it } -> 2
                            else -> 1
                        }
                    curRow = row
                    availableSeats[0] = true
                    availableSeats[1] = true
                    availableSeats[2] = true
                }
                when (seat) {
                    in 2..3 -> availableSeats[0] = false
                    in 4..5 -> {
                        availableSeats[0] = false
                        availableSeats[1] = false
                    }
                    in 6..7 -> {
                        availableSeats[1] = false
                        availableSeats[2] = false
                    }
                    in 8..9 -> availableSeats[2] = false
                }
            }
            result -=
                when {
                    availableSeats[0] && availableSeats[2] -> 0
                    availableSeats.none { it } -> 2
                    else -> 1
                }
            return result
        }
    }
}
