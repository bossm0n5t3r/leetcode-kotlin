package me.bossm0n5t3r.leetcode.minimumHeightTrees

import java.util.LinkedList
import java.util.Queue

class MinimumHeightTrees {
    class Solution {
        fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
            if (edges.isEmpty()) return listOf(0)

            val indegree = IntArray(n) { 0 }
            val graph = mutableMapOf<Int, MutableSet<Int>>()
            for (edge in edges) {
                val (v1, v2) = edge
                indegree[v1]++
                indegree[v2]++
                graph[v1] = graph.getOrDefault(v1, mutableSetOf()).apply { this.add(v2) }
                graph[v2] = graph.getOrDefault(v2, mutableSetOf()).apply { this.add(v1) }
            }

            val queue: Queue<Int> = LinkedList()
            for (i in indegree.indices) {
                if (indegree[i] == 1) queue.offer(i)
            }

            var remainingNodes = n
            while (remainingNodes > 2) {
                val size: Int = queue.size
                remainingNodes -= size
                for (i in 0 until size) {
                    val leaf = queue.poll()
                    for (neighbor in graph.getOrDefault(leaf, emptySet())) {
                        if (--indegree[neighbor] == 1) {
                            queue.add(neighbor)
                        }
                    }
                }
            }

            return queue.toList()
        }
    }
}
