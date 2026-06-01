package me.bossm0n5t3r.leetcode.sortintegersbythenumberof1bits

class SortIntegersByTheNumberOf1Bits {
    class Solution {
        fun sortByBits(arr: IntArray): IntArray =
            arr.groupBy { it.countOneBits() }
                .toList()
                .sortedBy { it.first }
                .flatMap { (_, value) -> value.sorted() }
                .toIntArray()
    }
}
