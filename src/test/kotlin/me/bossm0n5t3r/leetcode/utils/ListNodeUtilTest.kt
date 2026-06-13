package me.bossm0n5t3r.leetcode.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ListNodeUtilTest {
    @Test
    fun getLastListNodeTest() {
        val listNode = ListNodeUtil.generateListNode(1, 2, 3, 4, 5)
        val lastListNode = ListNodeUtil.getLastListNode(listNode!!)
        assertEquals(5, lastListNode.`val`)
    }

    @Test
    fun connectListNodeTest() {
        val basicListNode = ListNodeUtil.generateBasicSingleListNode()
        val listNodeData =
            listOf(
                basicListNode[0][1],
                basicListNode[0][3],
                basicListNode[0][5],
                basicListNode[0][7],
                basicListNode[0][9],
            )
        val expectListNodeVal = listOf(1, 3, 5, 7, 9)
        var cur: ListNode? = ListNodeUtil.connectListNode(listNodeData)
        for (i in expectListNodeVal.indices) {
            assertTrue(cur != null)
            assertEquals(expectListNodeVal[i], cur?.`val`)
            if (i == expectListNodeVal.size - 1) {
                assertTrue(cur?.next == null)
                break
            } else {
                cur = cur?.next
            }
        }
    }
}
