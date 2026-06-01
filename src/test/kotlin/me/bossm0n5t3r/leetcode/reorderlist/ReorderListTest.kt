package me.bossm0n5t3r.leetcode.reorderlist

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Test

class ReorderListTest {
    private val sut = ReorderList.Solution()

    private data class TestData(val head: ListNode?, val result: ListNode?)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4),
                    ListNodeUtil.generateListNode(1, 4, 2, 3),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    ListNodeUtil.generateListNode(1, 5, 2, 4, 3),
                ),
            )

        for (testData in testDataList) {
            sut.reorderList(testData.head)
            ListNodeUtil.isEqual(testData.head, testData.result)
        }
    }
}
