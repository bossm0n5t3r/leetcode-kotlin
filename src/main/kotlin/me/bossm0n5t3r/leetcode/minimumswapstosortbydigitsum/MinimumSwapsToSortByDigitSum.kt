package me.bossm0n5t3r.leetcode.minimumswapstosortbydigitsum

class MinimumSwapsToSortByDigitSum {
    class Solution {
        fun minSwaps(nums: IntArray): Int {
            val sortedNumsWithDigitSum =
                nums
                    .map { it to it.digitSum() }
                    .sortedWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
                    .map { it.first }

            // 각 숫자가 최종적으로 이동해야 하는 인덱스
            val targetIndex =
                sortedNumsWithDigitSum.withIndex().associate { (index, num) -> num to index }

            val visited = BooleanArray(nums.size)
            var result = 0

            for (i in nums.indices) {
                if (visited[i]) continue

                var current = i
                var cycleSize = 0

                while (!visited[current]) {
                    visited[current] = true
                    cycleSize++
                    current = targetIndex.getValue(nums[current])
                }

                result += cycleSize - 1
            }

            return result
        }

        private fun Int.digitSum(): Int {
            var result = 0
            var tmp = this
            while (tmp > 0) {
                result += tmp % 10
                tmp /= 10
            }
            return result
        }
    }
}
