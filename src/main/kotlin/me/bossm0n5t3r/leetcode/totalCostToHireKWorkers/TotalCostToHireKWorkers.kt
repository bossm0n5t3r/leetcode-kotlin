package me.bossm0n5t3r.leetcode.totalCostToHireKWorkers

import java.util.PriorityQueue
import kotlin.collections.ArrayDeque

class TotalCostToHireKWorkers {
    class Solution {
        fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
            if (costs.size < candidates * 2) {
                return costs.sorted().take(k).sumOf { it.toLong() }
            }
            var totalCost = 0L
            val costToIndexPriorityQueue =
                PriorityQueue(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })

            val costToIndex =
                costs.mapIndexed { index, cost -> cost to index }.sortedBy { it.second }

            val costToIndexArrayDeque =
                ArrayDeque<Pair<Int, Int>>().apply { this.addAll(costToIndex) }
            val firstIndices = mutableSetOf<Int>()
            val lastIndices = mutableSetOf<Int>()

            repeat(candidates) {
                val firstCostToIndex = costToIndexArrayDeque.removeFirst()
                val lastCostToIndex = costToIndexArrayDeque.removeLast()

                costToIndexPriorityQueue.offer(firstCostToIndex)
                costToIndexPriorityQueue.offer(lastCostToIndex)

                firstIndices.add(firstCostToIndex.second)
                lastIndices.add(lastCostToIndex.second)
            }

            repeat(k) {
                val (cost, index) = costToIndexPriorityQueue.poll()
                totalCost += cost

                if (firstIndices.contains(index)) {
                    firstIndices.remove(index)
                    if (costToIndexArrayDeque.isNotEmpty()) {
                        val firstCostToIndex = costToIndexArrayDeque.removeFirst()
                        costToIndexPriorityQueue.offer(firstCostToIndex)
                        firstIndices.add(firstCostToIndex.second)
                    }
                } else {
                    lastIndices.remove(index)
                    if (costToIndexArrayDeque.isNotEmpty()) {
                        val lastCostToIndex = costToIndexArrayDeque.removeLast()
                        costToIndexPriorityQueue.offer(lastCostToIndex)
                        lastIndices.add(lastCostToIndex.second)
                    }
                }
            }

            return totalCost
        }
    }
}
