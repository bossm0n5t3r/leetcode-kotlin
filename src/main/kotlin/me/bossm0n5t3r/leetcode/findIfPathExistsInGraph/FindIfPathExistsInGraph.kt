package me.bossm0n5t3r.leetcode.findIfPathExistsInGraph

import java.util.Stack

class FindIfPathExistsInGraph {
    class Solution {
        fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
            val graph = mutableMapOf<Int, MutableSet<Int>>()
            for ((from, to) in edges) {
                graph[from] = graph.getOrDefault(from, mutableSetOf()).apply { add(to) }
                graph[to] = graph.getOrDefault(to, mutableSetOf()).apply { add(from) }
            }
            val stack = Stack<Int>().apply { push(source) }
            val visited = BooleanArray(n) { false }
            while (stack.isNotEmpty()) {
                val cur = stack.pop()
                if (cur == destination) return true
                visited[cur] = true
                for (next in graph.getOrDefault(cur, mutableSetOf())) {
                    if (visited[next].not()) {
                        visited[next] = true
                        stack.push(next)
                    }
                }
            }
            return false
        }
    }
}
