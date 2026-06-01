package me.bossm0n5t3r.leetcode.maximumProductOfWordLengths

class MaximumProductOfWordLengths {
    class Solution {
        fun maxProduct(words: Array<String>): Int {
            val stringBits = getStringBits(words)
            var result = 0
            (0 until words.size - 1).forEach { i ->
                (i + 1 until words.size).forEach { j ->
                    if (
                        stringBits[i] and stringBits[j] == 0 &&
                            words[i].length * words[j].length > result
                    ) {
                        result = words[i].length * words[j].length
                    }
                }
            }
            return result
        }

        private fun getStringBits(words: Array<String>): IntArray {
            val n = words.size
            val result = IntArray(n) { 0 }
            words.forEachIndexed { index, s ->
                s.forEach { c ->
                    result[index] = result[index] or (1 shl (c.code - 'a'.code))
                    //                result[index] = result[index] or (1 shl (c.toByte().toInt() -
                    // 'a'.toByte().toInt()))
                }
            }
            return result
        }
    }
}
