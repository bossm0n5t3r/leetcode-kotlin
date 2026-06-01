package me.bossm0n5t3r.leetcode.defusethebomb

class DefuseTheBomb {
    class Solution {
        fun decrypt(code: IntArray, k: Int): IntArray {
            var result = IntArray(code.size).toList()
            if (k == 0) return result.toIntArray()
            var count = if (k > 0) k else -k
            val direction = if (k > 0) 1 else -1
            var tmp = code.toList()
            while (count-- > 0) {
                tmp = tmp.rotate(direction)
                result = result + tmp
            }
            return result.toIntArray()
        }

        private operator fun List<Int>.plus(other: List<Int>): List<Int> {
            require(this.size == other.size)
            return this.zip(other).map { it.first + it.second }
        }

        private fun <T> List<T>.rotate(distance: Int): List<T> {
            if (isEmpty()) return this
            val effectiveDistance = distance.mod(size)
            return subList(effectiveDistance, size) + subList(0, effectiveDistance)
        }
    }
}
