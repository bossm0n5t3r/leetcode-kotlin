package me.bossm0n5t3r.leetcode.doubleANumberRepresentedAsALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DoubleANumberRepresentedAsALinkedListTest {
    private val sut = DoubleANumberRepresentedAsALinkedList.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(1, 8, 9),
                    ListNodeUtil.generateListNode(3, 7, 8),
                ),
                TestData(
                    ListNodeUtil.generateListNode(9, 9, 9),
                    ListNodeUtil.generateListNode(1, 9, 9, 8),
                ),
            )

        tests.forEach { test ->
            assertTrue { ListNodeUtil.isEqual(test.result, sut.doubleIt(test.head)) }
        }
    }
}
