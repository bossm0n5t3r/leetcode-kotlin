package me.bossm0n5t3r.leetcode.evaluateDivision

import java.util.Stack

class EvaluateDivision {
    class Solution {
        fun calcEquation(
            equations: List<List<String>>,
            values: DoubleArray,
            queries: List<List<String>>,
        ): DoubleArray {
            val edges = mutableMapOf<String, MutableMap<String, Double>>()
            for (i in equations.indices) {
                val (from, to) = equations[i]
                val value = values[i]
                if (edges.containsKey(from).not()) {
                    edges[from] = mutableMapOf()
                }
                if (edges.containsKey(to).not()) {
                    edges[to] = mutableMapOf()
                }
                edges[from]?.put(to, value)
                edges[to]?.put(from, 1 / value)
            }
            val queriesSize = queries.size
            val result = DoubleArray(queriesSize) { 0.0 }
            for (i in queries.indices) {
                val answer = calculateUsingDFS(edges, queries[i])
                result[i] = answer
            }
            return result
        }

        @Suppress("ReturnCount")
        private fun calculateUsingDFS(
            edges: Map<String, Map<String, Double>>,
            query: List<String>,
        ): Double {
            val (from, to) = query
            if (edges.containsKey(to)) {
                if (edges[to]?.containsKey(from) == true) {
                    val value = edges[to]?.get(from) ?: error("Not found value")
                    return 1 / value
                }
            }
            if (edges.containsKey(from).not()) return -1.0
            if (from == to) return 1.0
            val stack = Stack<Pair<String, Double>>().apply { this.push(from to 1.0) }
            val visited = mutableSetOf(from)
            while (stack.isNotEmpty()) {
                val (cur, accumulatedResult) = stack.pop()
                if (cur == to) return accumulatedResult
                for ((next, value) in edges[cur] ?: emptyMap()) {
                    if (visited.contains(next).not()) {
                        visited.add(next)
                        stack.push(next to accumulatedResult * value)
                    }
                }
            }
            return -1.0
        }
    }
}
