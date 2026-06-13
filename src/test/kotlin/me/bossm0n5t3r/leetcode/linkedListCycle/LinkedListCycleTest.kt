package me.bossm0n5t3r.leetcode.linkedListCycle

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LinkedListCycleTest {
    private val linkedListCycle = LinkedListCycle.Solution()

    private val basicListNode = ListNodeUtil.generateBasicSingleListNode()

    data class LinkedListCycleTestData(val head: List<ListNode?>, val result: Boolean)

    @Test
    fun hasCycle() {
        val tests =
            listOf(
                LinkedListCycleTestData(
                    head =
                        listOf(
                            basicListNode[0][3],
                            basicListNode[0][2],
                            basicListNode[0][0],
                            basicListNode[0][4],
                            basicListNode[0][2],
                        ),
                    result = true,
                ),
                LinkedListCycleTestData(
                    head = listOf(basicListNode[0][1], basicListNode[0][2], basicListNode[0][1]),
                    result = true,
                ),
                LinkedListCycleTestData(head = listOf(basicListNode[0][1]), result = false),
            )
        tests.forEach { test ->
            val head = ListNodeUtil.connectListNode(test.head)
            assertEquals(test.result, linkedListCycle.hasCycleFirstApproach(head))
            assertEquals(test.result, linkedListCycle.hasCycleSecondApproach(head))
            assertEquals(test.result, linkedListCycle.hasCycleThirdApproach(head))
            ListNodeUtil.clearBasicSingleListNode(basicListNode)
        }
    }
}
