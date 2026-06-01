package me.bossm0n5t3r.leetcode.shiftinglettersii

class ShiftingLettersII {
    class Solution {
        fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
            val shiftResult =
                shifts.fold(IntArray(s.length)) { acc: IntArray, shift: IntArray ->
                    val (start, end, direction) = shift
                    val diff = if (direction == 0) -1 else 1
                    for (i in start..end) {
                        acc[i] += diff
                        if (acc[i] >= 26) acc[i] %= 26
                        if (acc[i] < 0) acc[i] += 26
                    }
                    acc
                }

            val result = s.toCharArray()
            for (i in s.indices) {
                var tmp = result[i] - 'a' + shiftResult[i]
                if (tmp >= 26) tmp %= 26
                if (tmp < 0) tmp += 26
                result[i] = 'a' + tmp
            }

            return String(result)
        }
    }
}
