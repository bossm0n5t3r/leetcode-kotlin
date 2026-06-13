package me.bossm0n5t3r.leetcode.maximumTwinSumOfALinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTwinSumOfALinkedListTest {
    private val sut = MaximumTwinSumOfALinkedList.Solution()

    private data class TestData(val head: ListNode?, val result: Int)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(ListNodeUtil.generateListNode(5, 4, 2, 1), 6),
                TestData(ListNodeUtil.generateListNode(4, 2, 2, 3), 7),
                TestData(ListNodeUtil.generateListNode(1, 100000), 100001),
            )

        tests.forEach { test -> assertEquals(test.result, sut.pairSum(test.head)) }
    }
}
