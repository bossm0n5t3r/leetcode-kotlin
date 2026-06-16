package me.bossm0n5t3r.leetcode.processstringwithspecialoperationsi

class ProcessStringWithSpecialOperationsI {
    class Solution {
        fun processStr(s: String): String {
            val result = StringBuilder()
            for (c in s) {
                when (c) {
                    '*' -> {
                        if (result.isNotEmpty()) {
                            result.deleteAt(result.lastIndex)
                        }
                    }
                    '#' -> {
                        val size = result.length
                        for (i in 0 until size) {
                            result.append(result[i])
                        }
                    }
                    '%' -> result.reverse()
                    else -> result.append(c)
                }
            }
            return result.toString()
        }
    }
}
