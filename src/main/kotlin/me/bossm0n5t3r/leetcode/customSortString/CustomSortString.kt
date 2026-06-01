package me.bossm0n5t3r.leetcode.customSortString

class CustomSortString {
    class Solution {
        fun customSortString(order: String, s: String): String =
            s.toList()
                .sortedBy {
                    val index = order.indexOf(it)
                    if (index == -1) {
                        Int.MAX_VALUE
                    } else {
                        index
                    }
                }
                .joinToString("")
    }
}
