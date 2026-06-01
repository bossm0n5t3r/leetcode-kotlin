package me.bossm0n5t3r.leetcode.splitLinkedListInParts

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SplitLinkedListInPartsTest {
    private val sut = SplitLinkedListInParts.Solution()

    private data class TestData(val head: ListNode?, val k: Int, val result: Array<ListNode?>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (head != other.head) return false
            if (k != other.k) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = head?.hashCode() ?: 0
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3),
                    5,
                    arrayOf(ListNode(1), ListNode(2), ListNode(3), null, null),
                ),
                TestData(
                    ListNodeUtil.generateListNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                    3,
                    arrayOf(
                        ListNodeUtil.generateListNode(1, 2, 3, 4),
                        ListNodeUtil.generateListNode(5, 6, 7),
                        ListNodeUtil.generateListNode(8, 9, 10),
                    ),
                ),
            )

        tests.forEach { test ->
            val result = sut.splitListToParts(test.head, test.k)
            assertThat(result).hasSize(test.result.size)
            for ((expected, actual) in test.result.zip(result)) {
                assertTrue { ListNodeUtil.isEqual(expected, actual) }
            }
        }
    }
}
