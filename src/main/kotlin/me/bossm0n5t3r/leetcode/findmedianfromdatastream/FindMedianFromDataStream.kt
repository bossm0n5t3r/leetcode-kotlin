package me.bossm0n5t3r.leetcode.findmedianfromdatastream

import java.util.PriorityQueue

class FindMedianFromDataStream {
    class MedianFinder {
        private var count = 0
        private val lower = PriorityQueue<Double>(compareByDescending { it })
        private val upper = PriorityQueue<Double>(compareBy { it })

        fun addNum(num: Int) {
            count++
            val number = num.toDouble()
            when {
                lower.isEmpty() -> lower.offer(number)
                number <= lower.peek() -> lower.offer(number)
                else -> upper.offer(number)
            }

            if (lower.size - upper.size >= 2) {
                upper.offer(lower.poll())
            } else if (upper.size - lower.size >= 2) {
                lower.offer(upper.poll())
            }
        }

        fun findMedian(): Double {
            return if (count % 2 == 1) {
                if (lower.size > upper.size) lower.peek() else upper.peek()
            } else {
                (lower.peek() + upper.peek()) / 2
            }
        }
    }
}
