package me.bossm0n5t3r.leetcode.middleOfTheLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MiddleOfTheLinkedListTest {
    private val sut = MiddleOfTheLinkedList.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    ListNodeUtil.generateListNode(3, 4, 5),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5, 6),
                    ListNodeUtil.generateListNode(4, 5, 6),
                ),
            )

        tests.forEach { test ->
            assertTrue(ListNodeUtil.isEqual(sut.middleNode(test.head), test.result))
        }
    }
}
