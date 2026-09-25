package me.bossm0n5t3r.leetcode.braceexpansionii

class BraceExpansionII {
    class Solution {
        private var index = 0

        private fun parseExpression(expression: String): MutableSet<String> {
            val unionResult = mutableSetOf<String>()
            var current = mutableSetOf("")
            while (index < expression.length && expression[index] != '}') {
                if (expression[index] == ',') {
                    // 지금까지 이어붙인 결과를 union에 합침
                    unionResult += current

                    // comma 뒤에서 새로운 그룹 시작
                    current = mutableSetOf("")

                    index++
                } else {
                    val next =
                        if (expression[index] == '{') {
                            index++
                            val result = parseExpression(expression)
                            index++
                            result
                        } else {
                            mutableSetOf("${expression[index++]}")
                        }

                    // 붙어 있는 표현식이므로 Cartesian Product
                    current = concat(current, next).toMutableSet()
                }
            }
            unionResult += current
            return unionResult
        }

        private fun concat(aSet: Set<String>, bSet: Set<String>): Set<String> {
            return buildSet {
                for (a in aSet) {
                    for (b in bSet) {
                        add(a + b)
                    }
                }
            }
        }

        fun braceExpansionII(expression: String): List<String> {
            index = 0
            return parseExpression(expression).sorted()
        }
    }
}
