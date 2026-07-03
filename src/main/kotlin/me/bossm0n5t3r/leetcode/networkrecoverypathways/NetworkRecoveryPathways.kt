package me.bossm0n5t3r.leetcode.networkrecoverypathways

import java.util.PriorityQueue

class NetworkRecoveryPathways {
    class Solution {
        fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
            val n = online.size
            if (n == 1) return -1
            if (edges.isEmpty()) return -1

            // 노드 0과 n-1은 항상 online이므로,
            // 양쪽 끝 중 offline인 노드가 있는 edge는 아예 사용 불가능
            val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
            var minWeight = Int.MAX_VALUE
            var maxWeight = Int.MIN_VALUE
            for ((u, v, w) in edges) {
                if (!online[u] || !online[v]) continue
                adj[u].add(v to w)
                minWeight = minOf(minWeight, w)
                maxWeight = maxOf(maxWeight, w)
            }

            var low = minWeight
            var high = maxWeight
            var answer = -1
            while (low <= high) {
                val mid = low + (high - low) / 2
                if (canReachWithMinScore(adj, mid, k, n)) {
                    answer = mid
                    low = mid + 1
                } else {
                    high = mid - 1
                }
            }
            return answer
        }

        private fun canReachWithMinScore(
            adj: Array<MutableList<Pair<Int, Int>>>,
            minScore: Int,
            k: Long,
            n: Int,
        ): Boolean {
            val dist = LongArray(n) { Long.MAX_VALUE }
            dist[0] = 0L
            val pq = PriorityQueue<Pair<Int, Long>>(compareBy { it.second })
            pq.offer(0 to 0L)

            while (pq.isNotEmpty()) {
                val (u, d) = pq.poll()
                if (d > dist[u]) continue
                if (u == n - 1) return d <= k

                for ((v, w) in adj[u]) {
                    if (w < minScore) continue
                    val next = d + w.toLong()
                    if (next < dist[v]) {
                        dist[v] = next
                        pq.offer(v to next)
                    }
                }
            }
            return dist[n - 1] <= k
        }
    }
}
