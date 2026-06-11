package me.bossm0n5t3r.leetcode.numberofwaystoassignedgeweightsi

import java.math.BigDecimal
import java.util.Stack

class NumberOfWaysToAssignEdgeWeightsI {
    class Solution {
        fun assignEdgeWeights(edges: Array<IntArray>): Int {
            val n = edges.size + 1
            val map = mutableMapOf<Int, MutableList<Int>>()
            for ((u, v) in edges) {
                map[u] = map.getOrDefault(u, mutableListOf()).apply { add(v) }
                map[v] = map.getOrDefault(v, mutableListOf()).apply { add(u) }
            }
            val maxDepth = dfs(map, n).also { println(it.toList()) }.max()
            return BigDecimal.valueOf(2L)
                .pow(maxDepth - 1)
                .remainder(BigDecimal.valueOf(1_000_000_007))
                .toInt()
        }

        private data class Node(val cur: Int, val depth: Int)

        private fun dfs(map: Map<Int, List<Int>>, n: Int): IntArray {
            val visited = BooleanArray(n + 1) { false }
            val depth = IntArray(n + 1) { 0 }
            val stack = Stack<Node>()
            stack.push(Node(1, 0))

            while (stack.isNotEmpty()) {
                val (curNode, curDepth) = stack.pop()
                visited[curNode] = true
                val candidates = map[curNode].orEmpty()
                if (candidates.isEmpty() || candidates.all { visited[it] }) {
                    depth[curNode] = curDepth
                    continue
                }
                for (nextNode in candidates) {
                    if (!visited[nextNode]) {
                        stack.push(Node(nextNode, curDepth + 1))
                    }
                }
            }

            return depth
        }
    }
}
