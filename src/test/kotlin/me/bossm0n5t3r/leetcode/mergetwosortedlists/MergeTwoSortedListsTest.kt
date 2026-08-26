package me.bossm0n5t3r.leetcode.mergetwosortedlists

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MergeTwoSortedListsTest {
    private val mergeTwoSortedLists = MergeTwoSortedLists.Solution()

    data class MergeTwoSortedListsTestData(
        val l1: ListNode?,
        val l2: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun mergeTwoLists() {
        val tests =
            listOf(
                MergeTwoSortedListsTestData(
                    ListNodeUtil.generateListNode(1, 2, 4),
                    ListNodeUtil.generateListNode(1, 3, 4),
                    ListNodeUtil.generateListNode(1, 1, 2, 3, 4, 4),
                ),
                MergeTwoSortedListsTestData(
                    ListNodeUtil.generateListNode(),
                    ListNodeUtil.generateListNode(),
                    ListNodeUtil.generateListNode(),
                ),
                MergeTwoSortedListsTestData(
                    ListNodeUtil.generateListNode(),
                    ListNodeUtil.generateListNode(0),
                    ListNodeUtil.generateListNode(0),
                ),
            )
        tests.forEach { test ->
            assertTrue(
                ListNodeUtil.isEqual(
                    mergeTwoSortedLists.mergeTwoLists(test.l1, test.l2),
                    test.result,
                )
            )
        }
    }
}
