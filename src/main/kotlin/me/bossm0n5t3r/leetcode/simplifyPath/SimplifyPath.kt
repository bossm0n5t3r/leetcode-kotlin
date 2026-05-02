package me.bossm0n5t3r.leetcode.simplifyPath

class SimplifyPath {
    class Solution {
        fun simplifyPath(path: String): String {
            val directories = path.split("/")
            var directoriesIndex = 0
            val result = Array(directories.size) { "" }
            var resultIndex = 0
            while (directoriesIndex < directories.size) {
                val cur = directories[directoriesIndex++]
                if (cur.isBlank()) continue
                when (cur) {
                    ".." -> {
                        resultIndex = (resultIndex - 1).coerceAtLeast(0)
                    }

                    "." -> {
                        continue
                    }

                    else -> {
                        result[resultIndex++] = cur
                    }
                }
            }
            return "/${result.take(resultIndex).joinToString("/")}"
        }
    }
}
