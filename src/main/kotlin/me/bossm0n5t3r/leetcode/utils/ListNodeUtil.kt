package me.bossm0n5t3r.leetcode.utils

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

object ListNodeUtil {
    fun generateArrayOfListNode(value: String): Array<ListNode?> =
        value.toArrayOfIntArray().map { generateListNode(*it) }.toTypedArray()

    fun generateListNode(string: String): ListNode? = generateListNode(*string.toIntArray())

    fun generateListNode(vararg values: Int): ListNode? {
        val head = values.toList()
        if (head.isEmpty()) return null
        val length = head.size
        val result = ListNode(head[0])
        var cur = result
        for (i in 1 until length) {
            cur.next = ListNode(head[i])
            cur = cur.next!!
        }
        return result
    }

    fun findListNodeByValue(value: Int, head: ListNode): ListNode {
        var cur = head
        while (cur.`val` != value) {
            cur = cur.next!!
        }
        return cur
    }

    fun listNodeToList(listNode: ListNode?): List<Int> {
        val result = mutableListOf<Int>()
        var cur: ListNode? = listNode
        while (cur != null) {
            result.add(cur.`val`)
            cur = cur.next
        }
        return result
    }

    fun isEqual(first: ListNode?, second: ListNode?): Boolean {
        if (first == null && second == null) return true
        if (first == null || second == null) {
            print("First ")
            printListNode(first)
            print("Second ")
            printListNode(second)
            return false
        }
        var curFirst: ListNode? = first
        var curSecond: ListNode? = second
        while (curFirst != null && curSecond != null) {
            if (curFirst.`val` != curSecond.`val`) {
                print("First ")
                printListNode(first)
                print("Second ")
                printListNode(second)
                return false
            }
            if (curFirst.next == null && curSecond.next == null) return true
            curFirst = curFirst.next
            curSecond = curSecond.next
        }
        return true
    }

    fun generateBasicSingleListNode(): List<List<ListNode>> {
        val result = mutableListOf<List<ListNode>>()
        (0..9).forEach { _ ->
            val basicResult = mutableListOf<ListNode>()
            (0..9).forEach { i -> basicResult.add(ListNode(i)) }
            result.add(basicResult)
        }
        return result
    }

    fun clearBasicSingleListNode(basicSingleListNode: List<List<ListNode>>) {
        (0..9).forEach { index ->
            val basicResult = basicSingleListNode[index]
            (0..9).forEach { i ->
                basicResult[i].`val` = i
                basicResult[i].next = null
            }
        }
    }

    fun getLastListNode(listNode: ListNode): ListNode {
        var cur: ListNode? = listNode
        while (cur != null) {
            val next = cur.next ?: return cur
            cur = next
        }
        return listNode
    }

    fun connectListNode(listNodeData: List<ListNode?>): ListNode? {
        if (listNodeData.size <= 1) return listNodeData.first()
        var cur: ListNode? = listNodeData.first()
        for (i in 1 until listNodeData.size) {
            cur?.next = listNodeData[i]
            cur = cur?.next
        }
        return listNodeData.first()
    }

    fun printListNode(listNode: ListNode?) {
        var cur = listNode
        val valueList = mutableListOf<Int>()
        while (cur != null) {
            valueList.add(cur.`val`)
            cur = cur.next
        }
        println("ListNode : ${valueList.joinToString(" ")}")
    }
}
