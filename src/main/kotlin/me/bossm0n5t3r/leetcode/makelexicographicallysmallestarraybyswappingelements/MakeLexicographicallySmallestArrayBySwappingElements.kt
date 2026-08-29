package me.bossm0n5t3r.leetcode.makelexicographicallysmallestarraybyswappingelements

import java.util.PriorityQueue

class MakeLexicographicallySmallestArrayBySwappingElements {
    class Solution {
        fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
            return nums
                .withIndex()
                .groupByLimit(limit)
                .map { it.orderByAscending() }
                .sorted()
                .toIntArray()
        }

        private fun Iterable<IndexedValue<Int>>.groupByLimit(
            limit: Int
        ): List<List<IndexedValue<Int>>> {
            val result = mutableListOf<MutableList<IndexedValue<Int>>>()
            val pq = PriorityQueue<IndexedValue<Int>>(compareBy { it.value })
            pq.addAll(this)
            while (pq.isNotEmpty()) {
                val cur = pq.poll()
                if (result.isEmpty()) {
                    result += mutableListOf(cur)
                    continue
                }
                val tmp = result.lastOrNull()?.lastOrNull() ?: continue
                if (cur.value - tmp.value <= limit) {
                    result[result.lastIndex] =
                        result.getOrElse(result.lastIndex) { mutableListOf() }.apply { add(cur) }
                } else {
                    result += mutableListOf(cur)
                }
            }
            return result
        }

        private fun List<IndexedValue<Int>>.orderByAscending(): List<IndexedValue<Int>> {
            val indices = this.map { it.index }.sorted()
            val values = this.map { it.value }.sorted()
            return indices.zip(values).map { IndexedValue(it.first, it.second) }
        }

        private fun List<List<IndexedValue<Int>>>.sorted(): List<Int> {
            return this.flatten().sortedBy { it.index }.map { it.value }
        }
    }
}
