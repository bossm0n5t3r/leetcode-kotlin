package me.bossm0n5t3r.leetcode.removeinvalidparentheses

class RemoveInvalidParentheses {
    class Solution {
        fun removeInvalidParentheses(s: String): List<String> {
            var leftRemove = 0
            var rightRemove = 0

            // 먼저 최소로 몇 개 지워야 하는지 계산
            for (char in s) {
                if (char == '(') {
                    leftRemove++
                } else if (char == ')') {
                    if (leftRemove > 0) leftRemove-- else rightRemove++
                }
            }

            val result = mutableSetOf<String>()

            fun StringBuilder.surround(char: Char, action: (sb: StringBuilder) -> Unit) {
                append(char)
                action(this)
                deleteCharAt(lastIndex)
            }

            fun dfs(
                index: Int,
                balance: Int,
                leftRemove: Int,
                rightRemove: Int,
                current: StringBuilder,
            ) {
                if (balance < 0) return
                if (leftRemove < 0 || rightRemove < 0) return

                if (index == s.length) {
                    if (balance == 0 && leftRemove == 0 && rightRemove == 0)
                        result.add(current.toString())
                    return
                }

                val char = s[index]

                if (char != '(' && char != ')') {
                    current.surround(char) { sb ->
                        dfs(index + 1, balance, leftRemove, rightRemove, sb)
                    }
                } else if (char == '(') {
                    // 이 '('를 삭제
                    if (leftRemove > 0) {
                        dfs(index + 1, balance, leftRemove - 1, rightRemove, current)
                    }
                    current.surround('(') {
                        dfs(index + 1, balance + 1, leftRemove, rightRemove, it)
                    }
                } else {
                    // 이 ')'를 삭제
                    if (rightRemove > 0) {
                        dfs(index + 1, balance, leftRemove, rightRemove - 1, current)
                    }

                    // 이 ')'를 사용
                    // balance가 0이면 ')'를 사용할 수 없음
                    if (balance > 0) {
                        current.surround(')') {
                            dfs(index + 1, balance - 1, leftRemove, rightRemove, it)
                        }
                    }
                }
            }

            dfs(index = 0, balance = 0, leftRemove, rightRemove, current = StringBuilder())

            return result.toList()
        }
    }
}
