package me.bossm0n5t3r.leetcode.convertbinarynumberinalinkedlisttointeger

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConvertBinaryNumberInALinkedListToIntegerTest {
    private val sut = ConvertBinaryNumberInALinkedListToInteger.Solution()

    private data class TestData(val head: ListNode?, val result: Int)

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(ListNodeUtil.generateListNode(1, 0, 1), 5),
                TestData(ListNodeUtil.generateListNode(0), 0),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.getDecimalValue(testData.head))
        }
    }
}
