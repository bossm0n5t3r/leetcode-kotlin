package me.bossm0n5t3r.leetcode.unique3digitevennumbers

class Unique3DigitEvenNumbers {
    class Solution {
        fun totalNumbers(digits: IntArray): Int {
            val result = mutableSetOf<String>()
            val visited = BooleanArray(digits.size)
            dfs(digits, visited, "", result)
            return result.size
        }

        private fun dfs(
            digits: IntArray,
            visited: BooleanArray,
            cur: String,
            result: MutableSet<String>,
        ) {
            if (cur.length == 3) {
                if (cur[0] != '0' && cur[2].digitToInt() % 2 == 0) {
                    result += cur
                }
                return
            }
            for (i in digits.indices) {
                if (visited[i]) continue
                visited[i] = true
                dfs(digits, visited, cur + digits[i], result)
                visited[i] = false
            }
        }
    }
}
