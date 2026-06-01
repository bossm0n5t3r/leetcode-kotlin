package me.bossm0n5t3r.leetcode.zigzagConversion

class ZigzagConversion {
    class Solution {
        fun convert(s: String, numRows: Int): String {
            val result = Array(numRows) { mutableListOf<Char>() }
            val index = Index(numRows)
            s.forEach { c ->
                val nextIdx = index.next().idx
                result[nextIdx].add(c)
            }
            return result.joinToString("") { it.joinToString("") }
        }

        private data class Index(
            val numRows: Int,
            var idx: Int = -1,
            var direction: Direction = Direction.DOWN,
        ) {
            fun next(): Index {
                when (this.direction) {
                    Direction.DOWN -> {
                        if (idx < numRows - 1) {
                            idx++
                            if (idx == numRows - 1) {
                                this.direction = Direction.UP
                            }
                        }
                    }

                    Direction.UP -> {
                        if (idx > 0) {
                            idx--
                            if (idx == 0) {
                                this.direction = Direction.DOWN
                            }
                        }
                    }
                }
                return this
            }
        }

        private enum class Direction {
            DOWN,
            UP,
        }

        fun convertAt20250110(s: String, numRows: Int): String {
            if (numRows == 1) return s
            val result = StringBuilder()
            for (i in numRows.generateIndices(s.length)) {
                result.append(s[i])
            }
            return String(result)
        }

        private fun Int.generateIndices(length: Int): List<Int> {
            val diffs = getDiffs()
            val result = mutableListOf<Int>()
            var index = 0
            while (index < this) {
                val diff = diffs[index]
                var diffIndex = 0
                var tmp = index
                while (tmp < length) {
                    result.add(tmp)
                    tmp += diff[diffIndex++]
                    if (diffIndex == diff.size) {
                        diffIndex = 0
                    }
                }
                index++
            }
            return result
        }

        private fun Int.getDiffs(): List<List<Int>> {
            val diff = List(this) { mutableListOf<Int>() }
            val total = 2 * this - 2
            for (i in 0 until this) {
                if (i == 0 || i == this - 1) {
                    diff[i].add(total)
                    continue
                }
                diff[i].add(total - 2 * i)
                diff[i].add(2 * i)
            }
            return diff
        }
    }
}
