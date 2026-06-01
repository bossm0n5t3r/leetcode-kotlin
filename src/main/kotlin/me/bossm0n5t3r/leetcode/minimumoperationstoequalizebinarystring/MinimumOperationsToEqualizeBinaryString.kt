package me.bossm0n5t3r.leetcode.minimumoperationstoequalizebinarystring

import java.util.ArrayDeque
import java.util.Queue
import java.util.TreeSet

class MinimumOperationsToEqualizeBinaryString {
    class Solution {
        fun minOperations(s: String, k: Int): Int {
            val n = s.length
            var m = 0
            val dist = IntArray(n + 1) { Int.MAX_VALUE }
            val nodeSets = listOf(TreeSet<Int>(), TreeSet<Int>())
            for (i in 0..n) {
                nodeSets[i % 2].add(i)
                if (i < n && s[i] == '0') {
                    m++
                }
            }
            val queue: Queue<Int> = ArrayDeque()
            queue.offer(m)
            dist[m] = 0
            nodeSets[m % 2].remove(m)
            while (!queue.isEmpty()) {
                m = queue.poll()
                val c1 = maxOf(k - n + m, 0)
                val c2 = minOf(m, k)
                val lNode = m + k - 2 * c2
                val rNode = m + k - 2 * c1
                val nodeSet = nodeSets[lNode % 2]
                var m2 = nodeSet.ceiling(lNode)
                while (m2 != null && m2 <= rNode) {
                    dist[m2] = dist[m] + 1
                    queue.offer(m2)
                    nodeSet.remove(m2)
                    m2 = nodeSet.ceiling(lNode)
                }
            }
            return if (dist[0] == Int.MAX_VALUE) -1 else dist[0]
        }
    }
}
