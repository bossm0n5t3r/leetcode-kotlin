package me.bossm0n5t3r.leetcode.mergeKSortedLists

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MergeKSortedListsTest {
    private val sut = MergeKSortedLists.Solution()

    private data class TestData(val lists: Array<ListNode?>, val result: ListNode?) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!lists.contentEquals(other.lists)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = lists.contentHashCode()
            result1 = 31 * result1 + (result?.hashCode() ?: 0)
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateArrayOfListNode("[[1,4,5],[1,3,4],[2,6]]"),
                    ListNodeUtil.generateListNode("[1,1,2,3,4,4,5,6]"),
                ),
                TestData(
                    ListNodeUtil.generateArrayOfListNode("[]"),
                    ListNodeUtil.generateListNode("[]"),
                ),
                TestData(
                    ListNodeUtil.generateArrayOfListNode("[[]]"),
                    ListNodeUtil.generateListNode("[]"),
                ),
            )

        tests.forEach { test ->
            assertTrue { ListNodeUtil.isEqual(sut.mergeKLists(test.lists), test.result) }
        }
    }
}
