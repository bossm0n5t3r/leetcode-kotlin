package me.bossm0n5t3r.leetcode.findthemaximumfactorscoreofarray

class FindTheMaximumFactorScoreOfArray {
    class Solution {
        fun maxScore(nums: IntArray): Long {
            return nums
                .sorted()
                .map { it.toLong() }
                .let {
                    if (it.size == 1) return it[0] * it[0]
                    var result = it.gcd() * it.lcm()
                    for (i in it.indices) {
                        val tmp = it.toMutableList()
                        tmp.removeAt(i)
                        result = maxOf(result, tmp.gcd() * tmp.lcm())
                    }
                    result
                }
        }

        private fun List<Long>.gcd(): Long = reduce { acc, i -> gcd(acc, i) }

        private fun List<Long>.lcm(): Long = reduce { acc, i -> lcm(acc, i) }

        private fun gcd(a: Long, b: Long): Long = if (b == 0L) a else gcd(b, a % b)

        private fun lcm(a: Long, b: Long): Long = a / gcd(a, b) * b
    }
}
