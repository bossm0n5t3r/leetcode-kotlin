package me.bossm0n5t3r.leetcode.backspaceStringCompare

import java.util.Stack

class BackspaceStringCompare {
    class Solution {
        fun backspaceCompare(s: String, t: String): Boolean {
            val sStack = Stack<Char>()
            val tStack = Stack<Char>()
            s.forEach { c ->
                if (c != '#') {
                    sStack.add(c)
                } else {
                    if (sStack.isNotEmpty()) sStack.pop()
                }
            }
            t.forEach { c ->
                if (c != '#') {
                    tStack.add(c)
                } else {
                    if (tStack.isNotEmpty()) tStack.pop()
                }
            }
            return sStack == tStack
        }

        fun backspaceCompareWithRestriction(s: String, t: String): Boolean {
            // Follow up: Can you solve it in O(n) time and O(1) space?
            var sIdx = s.length - 1
            var tIdx = t.length - 1
            var back: Int
            while (true) {
                back = 0
                while (sIdx >= 0 && (back > 0 || s[sIdx] == '#')) {
                    back += if (s[sIdx] == '#') 1 else -1
                    sIdx--
                }
                back = 0
                while (tIdx >= 0 && (back > 0 || t[tIdx] == '#')) {
                    back += if (t[tIdx] == '#') 1 else -1
                    tIdx--
                }
                if (sIdx >= 0 && tIdx >= 0 && s[sIdx] == t[tIdx]) {
                    sIdx--
                    tIdx--
                } else {
                    break
                }
            }
            return sIdx == -1 && tIdx == -1
        }
    }
}
