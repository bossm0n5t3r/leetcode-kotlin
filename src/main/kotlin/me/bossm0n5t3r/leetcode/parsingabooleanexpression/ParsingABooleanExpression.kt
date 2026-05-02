package me.bossm0n5t3r.leetcode.parsingabooleanexpression

import java.util.Stack

class ParsingABooleanExpression {
    class Solution {
        fun parseBoolExpr(expression: String): Boolean {
            val stack = Stack<Char>()
            for (c in expression) {
                when (c) {
                    ')' -> {
                        val subExpressionList = mutableListOf<Boolean>()
                        while (stack.isNotEmpty() && stack.peek() != '(') {
                            val tmp = stack.pop()
                            if (tmp != ',') {
                                subExpressionList.add(tmp == 't')
                            }
                        }
                        stack.pop()
                        val newExpression =
                            when (val logicalOperator = stack.pop()) {
                                '!' -> subExpressionList.first().not()
                                '&' -> subExpressionList.fold(true) { acc, it -> acc && it }
                                '|' -> subExpressionList.fold(false) { acc, it -> acc || it }
                                else -> error("Unknown logicalOperator: $logicalOperator")
                            }
                        stack.push(if (newExpression) 't' else 'f')
                    }

                    else -> {
                        stack.push(c)
                    }
                }
            }
            return stack.pop() == 't'
        }
    }
}
