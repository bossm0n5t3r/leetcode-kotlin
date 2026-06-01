package me.bossm0n5t3r.leetcode.smallestNumberInInfiniteSet

import java.util.PriorityQueue

class SmallestNumberInInfiniteSet {
    class SmallestInfiniteSet {
        private val pq = PriorityQueue<Int> { e1, e2 -> e1 - e2 }
        private val elementsOfPriorityQueue = mutableSetOf<Int>()

        private var fillQueueIndex = 1
        private val batchSize = 100

        private fun fillQueue() {
            repeat(batchSize) {
                val element = fillQueueIndex++
                pq.offer(element)
                elementsOfPriorityQueue.add(element)
            }
        }

        init {
            fillQueue()
        }

        fun popSmallest(): Int =
            pq.poll().also {
                elementsOfPriorityQueue.remove(it)
                if (pq.isEmpty()) fillQueue()
            }

        fun addBack(num: Int) {
            if (elementsOfPriorityQueue.contains(num).not() && fillQueueIndex > num) {
                pq.offer(num)
                elementsOfPriorityQueue.add(num)
            }
        }
    }
}
