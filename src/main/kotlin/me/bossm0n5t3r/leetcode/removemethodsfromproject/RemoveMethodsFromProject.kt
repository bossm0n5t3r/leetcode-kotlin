package me.bossm0n5t3r.leetcode.removemethodsfromproject

import java.util.LinkedList
import java.util.Queue

class RemoveMethodsFromProject {
    class Solution {
        fun remainingMethods(n: Int, k: Int, invocations: Array<IntArray>): List<Int> {
            val graph = mutableMapOf<Int, MutableList<Int>>()
            for ((a, b) in invocations) {
                graph[a] = graph.getOrDefault(a, mutableListOf()).apply { add(b) }
            }
            val suspicious = BooleanArray(n) { false }
            bfs(k, suspicious, graph)
            for ((a, b) in invocations) {
                if (!suspicious[a] && suspicious[b]) return (0..<n).toList()
            }
            return (0..<n).filterNot { suspicious[it] }
        }

        private fun bfs(k: Int, suspicious: BooleanArray, graph: Map<Int, List<Int>>) {
            val queue: Queue<Int> = LinkedList()
            queue.offer(k)
            while (queue.isNotEmpty()) {
                val cur = queue.poll()
                suspicious[cur] = true
                val candidates = graph[cur].orEmpty()
                for (candidate in candidates) {
                    if (!suspicious[candidate]) {
                        suspicious[candidate] = true
                        queue.offer(candidate)
                    }
                }
            }
        }
    }
}
