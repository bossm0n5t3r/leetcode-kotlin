package me.bossm0n5t3r.leetcode.addTwoNumbers

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class AddTwoNumbersTest {
    private val addTwoNumbers = AddTwoNumbers.Solution()

    private data class AddTwoNumbersTestData(
        val l1: ListNode?,
        val l2: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun addTwoNumbers() {
        val tests =
            listOf(
                AddTwoNumbersTestData(
                    ListNodeUtil.generateListNode(2, 4, 3),
                    ListNodeUtil.generateListNode(5, 6, 4),
                    ListNodeUtil.generateListNode(7, 0, 8),
                ),
                AddTwoNumbersTestData(
                    ListNodeUtil.generateListNode(0),
                    ListNodeUtil.generateListNode(0),
                    ListNodeUtil.generateListNode(0),
                ),
                AddTwoNumbersTestData(
                    ListNodeUtil.generateListNode(9, 9, 9, 9, 9, 9, 9),
                    ListNodeUtil.generateListNode(9, 9, 9, 9),
                    ListNodeUtil.generateListNode(8, 9, 9, 9, 0, 0, 0, 1),
                ),
            )
        tests.forEach { test ->
            //            println(ListNodeUtil.listNodeToList(addTwoNumbers.addTwoNumbers(test.l1,
            // test.l2)))
            assertTrue(
                ListNodeUtil.isEqual(addTwoNumbers.addTwoNumbers(test.l1, test.l2), test.result)
            )
        }
    }
}
