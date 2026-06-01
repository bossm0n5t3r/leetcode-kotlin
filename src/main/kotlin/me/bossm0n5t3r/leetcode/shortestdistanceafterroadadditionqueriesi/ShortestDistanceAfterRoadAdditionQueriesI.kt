package me.bossm0n5t3r.leetcode.shortestdistanceafterroadadditionqueriesi

import java.util.LinkedList
import java.util.Queue

class ShortestDistanceAfterRoadAdditionQueriesI {
    class Solution {
        fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
            val (from, to) = 0 to n - 1
            val defaultMap =
                (from..to)
                    .windowed(2)
                    .associate { it.first() to mutableListOf(it.last()) }
                    .toMutableMap()
            return queries
                .map { (u, v) ->
                    defaultMap
                        .apply { this[u] = this.getOrDefault(u, mutableListOf()).apply { add(v) } }
                        .shortest(from, to)
                }
                .toIntArray()
        }

        private fun Map<Int, List<Int>>.shortest(from: Int, to: Int): Int {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.offer(from to 0)
            val visited = BooleanArray(to + 1)
            while (queue.isNotEmpty()) {
                val (cur, step) = queue.poll()
                if (cur == to) return step
                visited[cur] = true
                for (neighbor in (this[cur] ?: emptyList())) {
                    if (visited[neighbor].not()) {
                        visited[neighbor] = true
                        queue.offer(neighbor to step + 1)
                    }
                }
            }
            error("Not found shortest: $this, $from, $to")
        }
    }
}
