package me.bossm0n5t3r.leetcode.networkDelayTime

import java.util.PriorityQueue

class NetworkDelayTime {
    class Solution {
        fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
            val graph =
                times
                    .groupBy { it.first() }
                    .mapValues { (_, value) -> value.map { it[1] to it[2] } }
            val (dist, _) = dijkstra(graph, n, k)

            return dist.maxOrNull()?.let {
                if (it == Int.MAX_VALUE) {
                    -1
                } else {
                    it
                }
            } ?: -1
        }

        private fun dijkstra(
            graph: Map<Int, List<Pair<Int, Int>>>,
            n: Int,
            start: Int,
        ): Pair<List<Int>, List<Int>> {
            val dist = IntArray(n + 1) { Int.MAX_VALUE }
            val prev = IntArray(n + 1) { -1 }
            dist[start] = 0
            val pq = PriorityQueue<List<Int>> { a, b -> a[0] - b[0] }
            (1..n).forEach { pq.add(listOf(dist[it], it)) }
            while (pq.isNotEmpty()) {
                val (d, u) = pq.poll()
                if (d > dist[u]) continue
                graph[u]?.forEach { (v, w) ->
                    if (dist[v] > dist[u] + w) {
                        dist[v] = dist[u] + w
                        prev[v] = u
                        pq.add(listOf(dist[v], v))
                    }
                }
            }
            return dist.drop(1) to prev.drop(1)
        }
    }
}
