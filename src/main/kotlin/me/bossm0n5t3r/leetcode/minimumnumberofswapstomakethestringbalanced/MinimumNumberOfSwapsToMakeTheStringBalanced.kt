package me.bossm0n5t3r.leetcode.minimumnumberofswapstomakethestringbalanced

class MinimumNumberOfSwapsToMakeTheStringBalanced {
    class Solution {
        fun minSwaps(s: String): Int {
            val sCharArray = s.toCharArray()
            var openBrackets = 0
            var closeBrackets = 0
            var closeBracketIndex = 0
            var openBracketIndex = s.lastIndex
            var result = 0
            for (c in sCharArray) {
                if (c == '[') openBrackets++ else closeBrackets++
                if (openBrackets < closeBrackets) {
                    val (updatedCloseBracketIndex, updatedOpenBracketIndex) =
                        swap(sCharArray, closeBracketIndex, openBracketIndex)
                    closeBracketIndex = updatedCloseBracketIndex
                    openBracketIndex = updatedOpenBracketIndex
                    closeBrackets--
                    openBrackets++
                    result++
                }
            }
            return result
        }

        private fun swap(sCharArray: CharArray, startIndex: Int, endIndex: Int): Pair<Int, Int> {
            var s = startIndex
            var e = endIndex
            while (s < sCharArray.size && sCharArray[s] == '[') {
                s++
            }
            while (e > 0 && sCharArray[e] == ']') {
                e--
            }
            val tmp = sCharArray[s]
            sCharArray[s] = sCharArray[e]
            sCharArray[e] = tmp
            return s to e
        }
    }
}
