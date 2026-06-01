package me.bossm0n5t3r.leetcode.mergeInBetweenLinkedLists

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MergeInBetweenLinkedListsTest {
    private val sut = MergeInBetweenLinkedLists.Solution()

    private data class TestData(
        val list1: ListNode?,
        val a: Int,
        val b: Int,
        val list2: ListNode?,
        val result: ListNode?,
    )

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(10, 1, 13, 6, 9, 5),
                    3,
                    4,
                    ListNodeUtil.generateListNode(1000000, 1000001, 1000002),
                    ListNodeUtil.generateListNode(10, 1, 13, 1000000, 1000001, 1000002, 5),
                ),
                TestData(
                    ListNodeUtil.generateListNode(0, 1, 2, 3, 4, 5, 6),
                    2,
                    5,
                    ListNodeUtil.generateListNode(1000000, 1000001, 1000002, 1000003, 1000004),
                    ListNodeUtil.generateListNode(
                        0,
                        1,
                        1000000,
                        1000001,
                        1000002,
                        1000003,
                        1000004,
                        6,
                    ),
                ),
            )

        tests.forEach { test ->
            assertTrue(
                ListNodeUtil.isEqual(
                    sut.mergeInBetween(test.list1, test.a, test.b, test.list2),
                    test.result,
                )
            )
        }
    }
}
