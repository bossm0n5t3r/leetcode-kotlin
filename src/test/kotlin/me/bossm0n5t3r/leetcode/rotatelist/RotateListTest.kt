package me.bossm0n5t3r.leetcode.rotatelist

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RotateListTest {
    private val sut = RotateList.Solution()

    private data class TestData(
        val head: ListNode?,
        val k: Int,
        val result: ListNode?,
    )

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    head = ListNodeUtil.generateListNode(1, 2, 3, 4, 5),
                    k = 2,
                    result = ListNodeUtil.generateListNode(4, 5, 1, 2, 3),
                ),
                TestData(
                    head = ListNodeUtil.generateListNode(0, 1, 2),
                    k = 4,
                    result = ListNodeUtil.generateListNode(2, 0, 1),
                ),
            )

        for (testData in testDataList) {
            assertTrue {
                ListNodeUtil.isEqual(
                    sut.rotateRight(testData.head, testData.k),
                    testData.result,
                )
            }
        }
    }
}
