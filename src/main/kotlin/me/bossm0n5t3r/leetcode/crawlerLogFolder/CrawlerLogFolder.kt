package me.bossm0n5t3r.leetcode.crawlerLogFolder

class CrawlerLogFolder {
    class Solution {
        fun minOperations(logs: Array<String>): Int {
            var depth = 0
            var curPath = "root"
            for (log in logs) {
                when (log) {
                    "../" -> {
                        if (curPath != "root" && depth > 0) {
                            depth--
                        }
                    }

                    "./" -> {}

                    else -> {
                        depth++
                        curPath = log.dropLast(1)
                    }
                }
            }
            return depth
        }
    }
}
