package me.bossm0n5t3r.leetcode.palindromeLinkedList

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PalindromeLinkedListTest {
    private val palindromeLinkedList = PalindromeLinkedList.Solution()

    data class PalindromeLinkedListTestData(val head: ListNode?, val result: Boolean)

    @Test
    fun isPalindrome() {
        val tests =
            listOf(
                PalindromeLinkedListTestData(ListNodeUtil.generateListNode(1, 2, 2, 1), true),
                PalindromeLinkedListTestData(ListNodeUtil.generateListNode(1, 2, 1, 2, 1), true),
                PalindromeLinkedListTestData(ListNodeUtil.generateListNode(1, 2), false),
            )
        tests.forEach { test ->
            assertEquals(palindromeLinkedList.isPalindrome(test.head), test.result)
        }
    }
}
