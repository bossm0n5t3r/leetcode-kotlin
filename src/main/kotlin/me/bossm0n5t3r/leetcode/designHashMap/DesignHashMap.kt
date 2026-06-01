package me.bossm0n5t3r.leetcode.designHashMap

class DesignHashMap {
    private val data = IntArray(1_000_000 + 1) { -1 }

    fun put(key: Int, value: Int) {
        data[key] = value
    }

    fun get(key: Int): Int = data[key]

    fun remove(key: Int) {
        data[key] = -1
    }
}

class DesignAnotherHashMap {
    private data class ListNode(val key: Int, val value: Int, var next: ListNode?)

    private val size = 19997
    private val mul = 12582917
    private val data = Array<ListNode?>(size) { null }

    private fun hash(key: Int) = (key.toLong() * mul % size).toInt()

    fun put(key: Int, value: Int) {
        remove(key)
        val h = hash(key)
        val node = ListNode(key, value, data[h])
        data[h] = node
    }

    fun get(key: Int): Int {
        val h = hash(key)
        var node = data[h]
        while (node != null) {
            if (node.key == key) return node.value
            node = node.next
        }
        return -1
    }

    fun remove(key: Int) {
        val h = hash(key)
        var node: ListNode? = data[h] ?: return
        if (node?.key == key) {
            data[h] = node.next
        } else {
            while (node?.next != null) {
                if (node.next?.key == key) {
                    node.next = node.next?.next
                    return
                }
                node = node.next
            }
        }
    }
}
