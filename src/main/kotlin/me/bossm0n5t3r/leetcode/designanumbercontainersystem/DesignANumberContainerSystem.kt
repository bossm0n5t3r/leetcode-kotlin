package me.bossm0n5t3r.leetcode.designanumbercontainersystem

import java.util.PriorityQueue

class DesignANumberContainerSystem {
    class NumberContainers {
        private val indexToNumber = mutableMapOf<Int, Int>()
        private val numberToIndexPriorityQueue = mutableMapOf<Int, PriorityQueue<Int>>()

        fun change(index: Int, number: Int) {
            val previousNumberOfIndex = indexToNumber[index] ?: -1
            indexToNumber[index] = number
            if (previousNumberOfIndex != -1) {
                numberToIndexPriorityQueue[previousNumberOfIndex] =
                    numberToIndexPriorityQueue[previousNumberOfIndex]?.apply { this.remove(index) }
                        ?: error("Unknown number: $previousNumberOfIndex")
            }
            numberToIndexPriorityQueue[number] =
                numberToIndexPriorityQueue.getOrDefault(number, PriorityQueue()).apply {
                    offer(index)
                }
        }

        fun find(number: Int): Int = numberToIndexPriorityQueue[number]?.peek() ?: -1
    }
}
