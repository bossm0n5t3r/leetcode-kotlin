package me.bossm0n5t3r.leetcode.textJustification

import java.util.LinkedList
import java.util.Queue

class TextJustification {
    class Solution {
        fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
            val result = mutableListOf<String>()
            val wordQueue = LinkedList<String>().apply { this.addAll(words) } as Queue<String>
            var tmpWordList = mutableListOf<String>()
            while (wordQueue.isNotEmpty()) {
                if (tmpWordList.currentLength() + wordQueue.peek().length + 1 > maxWidth) {
                    result.add(tmpWordList.buildFullJustifiedString(maxWidth, false))
                    tmpWordList = mutableListOf(wordQueue.poll())
                    continue
                }
                tmpWordList.add(wordQueue.poll())
            }
            if (tmpWordList.isNotEmpty()) {
                result.add(tmpWordList.buildFullJustifiedString(maxWidth, true))
            }
            return result
        }

        private fun List<String>.currentLength(): Int = this.sumOf { it.length } + (this.size - 1)

        private fun List<String>.buildFullJustifiedString(
            maxWidth: Int,
            isLastLine: Boolean,
        ): String {
            if (isLastLine) {
                val rawLastLine = this.joinToString(" ")
                return rawLastLine.padEnd(maxWidth)
            }
            if (this.size == 1) {
                return this.first().padEnd(maxWidth)
            }
            val spaces = IntArray(this.size - 1) { 0 }
            var spaceIndex = 0
            var curWidth = this.sumOf { it.length }
            while (curWidth < maxWidth) {
                spaces[spaceIndex++]++
                curWidth++
                if (spaceIndex == spaces.size) {
                    spaceIndex = 0
                }
            }
            val result = StringBuilder()
            for (i in 0 until this.size - 1) {
                result.append(this[i])
                result.append(" ".repeat(spaces[i]))
            }
            result.append(this.last())
            return result.toString()
        }
    }
}
