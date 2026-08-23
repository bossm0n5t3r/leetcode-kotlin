package me.bossm0n5t3r.leetcode.minstack

class MinStack {
    /** initialize your data structure here. */
    private val s = mutableListOf<Int>()
    private var min = Int.MAX_VALUE

    fun push(`val`: Int) {
        s.add(`val`)
        if (`val` < min) {
            min = `val`
        }
    }

    fun pop() {
        val last = s.last()
        s.removeAt(s.lastIndex)
        if (last == min) {
            min = if (s.isEmpty()) Int.MAX_VALUE else s.minOrNull()!!
        }
    }

    fun top(): Int = s.last()

    fun getMin(): Int = min
}
