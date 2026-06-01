package me.bossm0n5t3r.leetcode.mostbeautifulitemforeachquery

import java.util.TreeMap

class MostBeautifulItemForEachQuery {
    class Solution {
        fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
            val treeMap = TreeMap<Int, Int>()
            val sortedItems = items.sortedWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
            var maxBeauty = 0
            for ((price, beauty) in sortedItems) {
                val tmp = maxOf(maxBeauty, treeMap.getOrDefault(price, 0), beauty)
                treeMap[price] = tmp
                maxBeauty = tmp
            }
            return queries
                .toList()
                .map { query -> treeMap.floorEntry(query)?.value ?: 0 }
                .toIntArray()
        }
    }
}
