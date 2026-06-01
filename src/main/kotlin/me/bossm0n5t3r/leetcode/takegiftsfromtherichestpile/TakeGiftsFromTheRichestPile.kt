package me.bossm0n5t3r.leetcode.takegiftsfromtherichestpile

import java.util.PriorityQueue

class TakeGiftsFromTheRichestPile {
    class Solution {
        fun pickGifts(gifts: IntArray, k: Int): Long {
            val pq = PriorityQueue<Int>(compareByDescending { it })
            pq.addAll(gifts.toList())
            var times = k
            while (times-- > 0) {
                val maxNumberOfGift = pq.poll()
                pq.offer(maxNumberOfGift.squareRoot())
            }
            return pq.sumOf { it.toLong() }
        }

        private fun Int.squareRoot(div: Int = 1): Int =
            if (div * div <= this) this.squareRoot(div + 1) else div - 1
    }
}
