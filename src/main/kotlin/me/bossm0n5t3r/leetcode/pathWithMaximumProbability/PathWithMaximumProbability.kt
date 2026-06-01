package me.bossm0n5t3r.leetcode.pathWithMaximumProbability

import java.util.PriorityQueue

class PathWithMaximumProbability {
    class Solution {
        fun maxProbability(
            n: Int,
            edges: Array<IntArray>,
            succProb: DoubleArray,
            startNode: Int,
            endNode: Int,
        ): Double {
            val graph = mutableMapOf<Int, MutableList<Pair<Int, Double>>>()
            for (i in edges.indices) {
                val (u, v) = edges[i]
                graph.computeIfAbsent(u) { mutableListOf() }.add(v to succProb[i])
                graph.computeIfAbsent(v) { mutableListOf() }.add(u to succProb[i])
            }
            val dist = DoubleArray(n) { 0.0 }.apply { this[startNode] = 1.0 }
            val pq =
                PriorityQueue<Pair<Double, Int>>(compareBy { -it.first }).apply {
                    this.offer(1.0 to startNode)
                }
            while (pq.isNotEmpty()) {
                val (prob, node) = pq.poll()
                if (node == endNode) return prob
                for ((next, nextProb) in graph[node] ?: emptyList()) {
                    val newProb = prob * nextProb
                    if (newProb > dist[next]) {
                        dist[next] = newProb
                        pq.add(newProb to next)
                    }
                }
            }
            return 0.0
        }
    }
}
