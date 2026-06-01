package me.bossm0n5t3r.leetcode.maximumTotalImportanceOfRoads

class MaximumTotalImportanceOfRoads {
    class Solution {
        fun maximumImportance(n: Int, roads: Array<IntArray>): Long {
            val cityToCity = mutableMapOf<Int, MutableSet<Int>>()
            for ((u, v) in roads) {
                cityToCity.getOrPut(u) { mutableSetOf() }.add(v)
                cityToCity.getOrPut(v) { mutableSetOf() }.add(u)
            }
            val cityToValue =
                cityToCity
                    .toList()
                    .sortedByDescending { it.second.size }
                    .map { it.first }
                    .zip(n downTo 1)
                    .toMap()
            return roads.sumOf { (u, v) ->
                val uValue = cityToValue[u]?.toLong() ?: return@sumOf 0
                val vValue = cityToValue[v]?.toLong() ?: return@sumOf 0
                uValue + vValue
            }
        }
    }
}
