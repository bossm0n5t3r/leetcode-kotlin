package me.bossm0n5t3r.leetcode.sortCharactersByFrequency

class SortCharactersByFrequency {
    class Solution {
        fun frequencySort(s: String): String =
            s.groupingBy { it }
                .eachCount()
                .entries
                .sortedWith(compareBy({ -it.value }, { it.key }))
                .joinToString("") { it.key.toString().repeat(it.value) }
    }
}
