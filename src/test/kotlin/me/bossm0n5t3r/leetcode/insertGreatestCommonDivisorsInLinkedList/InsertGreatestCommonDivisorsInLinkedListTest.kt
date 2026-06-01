package me.bossm0n5t3r.leetcode.insertGreatestCommonDivisorsInLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InsertGreatestCommonDivisorsInLinkedListTest {
    private val sut = InsertGreatestCommonDivisorsInLinkedList.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(18, 6, 10, 3),
                    ListNodeUtil.generateListNode(18, 6, 6, 2, 10, 1, 3),
                ),
                TestData(ListNode(7), ListNode(7)),
            )

        tests.forEach { test ->
            assertTrue {
                ListNodeUtil.isEqual(sut.insertGreatestCommonDivisors(test.head), test.result)
            }
        }
    }
}
