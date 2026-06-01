package me.bossm0n5t3r.leetcode.numberofsubstringscontainingallthreecharacters

class NumberOfSubstringsContainingAllThreeCharacters {
    class Solution {
        fun numberOfSubstrings(s: String): Int {
            val abc = IntArray(3)
            var result = 0
            var (left, right) = 0 to 0
            while (right < s.length) {
                abc.update(s, right, 1)
                while (abc.allPositive()) {
                    result += s.length - right
                    abc.update(s, left++, -1)
                }
                right++
            }
            return result
        }

        private fun IntArray.allPositive() = this[0] > 0 && this[1] > 0 && this[2] > 0

        private fun IntArray.update(s: String, index: Int, diff: Int) {
            this[s[index].code - 'a'.code] += diff
        }
    }
}
