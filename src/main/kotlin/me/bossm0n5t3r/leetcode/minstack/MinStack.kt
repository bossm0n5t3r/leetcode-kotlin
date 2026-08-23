package me.bossm0n5t3r.leetcode.minstack

class MinStack {
    private val stack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)

        if (minStack.isEmpty() || `val` <= minStack.last()) {
            minStack.add(`val`)
        }
    }

    fun pop() {
        val value = stack.removeAt(stack.lastIndex)

        if (value == minStack.last()) {
            minStack.removeAt(minStack.lastIndex)
        }
    }

    fun top(): Int = stack.last()

    fun getMin(): Int = minStack.last()
}
