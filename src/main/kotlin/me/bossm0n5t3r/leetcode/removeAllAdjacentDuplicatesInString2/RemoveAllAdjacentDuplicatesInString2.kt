package me.bossm0n5t3r.leetcode.removeAllAdjacentDuplicatesInString2

class RemoveAllAdjacentDuplicatesInString2 {
    class Solution {
        fun removeDuplicates(s: String, k: Int): String {
            val n = s.length
            val count = IntArray(n)
            val stack = s.toCharArray()
            var i = 0
            var j = 0
            while (j < n) {
                stack[i] = stack[j]
                count[i] =
                    if (i > 0 && stack[i - 1] == stack[j]) {
                        count[i - 1] + 1
                    } else {
                        1
                    }
                if (count[i] == k) i -= k
                ++j
                ++i
            }
            return String(stack, 0, i)
        }
    }
}
