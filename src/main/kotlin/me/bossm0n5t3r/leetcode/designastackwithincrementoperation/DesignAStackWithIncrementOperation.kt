package me.bossm0n5t3r.leetcode.designastackwithincrementoperation

class DesignAStackWithIncrementOperation {
    class CustomStack(maxSize: Int) {
        private val store = IntArray(maxSize)
        private val initialIndex = -1
        private var index = initialIndex

        fun push(x: Int) {
            if (index == store.lastIndex) return
            store[++index] = x
        }

        fun pop(): Int {
            if (index == -1) return initialIndex
            return store[index--]
        }

        fun increment(k: Int, `val`: Int) {
            for (i in 0 until k) {
                if (i > index) break
                store[i] += `val`
            }
        }
    }
}
