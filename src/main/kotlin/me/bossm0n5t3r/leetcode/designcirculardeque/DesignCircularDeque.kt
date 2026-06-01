package me.bossm0n5t3r.leetcode.designcirculardeque

class DesignCircularDeque {
    class MyCircularDeque(private val k: Int) {
        private val arrayDeque = ArrayDeque<Int>(k)

        fun insertFront(value: Int): Boolean =
            if (this.isFull()) {
                false
            } else {
                arrayDeque.addFirst(value)
                true
            }

        fun insertLast(value: Int): Boolean =
            if (this.isFull()) {
                false
            } else {
                arrayDeque.addLast(value)
                true
            }

        fun deleteFront(): Boolean =
            if (this.isEmpty()) {
                false
            } else {
                arrayDeque.removeFirst()
                true
            }

        fun deleteLast(): Boolean =
            if (this.isEmpty()) {
                false
            } else {
                arrayDeque.removeLast()
                true
            }

        fun getFront(): Int = arrayDeque.firstOrNull() ?: -1

        fun getRear(): Int = arrayDeque.lastOrNull() ?: -1

        fun isEmpty(): Boolean = arrayDeque.isEmpty()

        fun isFull(): Boolean = arrayDeque.isNotEmpty() && arrayDeque.size == k
    }
}
