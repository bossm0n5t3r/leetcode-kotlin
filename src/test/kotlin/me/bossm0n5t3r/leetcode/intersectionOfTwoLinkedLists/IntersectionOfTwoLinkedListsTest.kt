package me.bossm0n5t3r.leetcode.intersectionOfTwoLinkedLists

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntersectionOfTwoLinkedListsTest {
    private val intersectionOfTwoLinkedLists = IntersectionOfTwoLinkedLists.Solution()

    private val basicSingleListNode = ListNodeUtil.generateBasicSingleListNode()

    data class IntersectionOfTwoLinkedListsTestData(
        val headA: List<ListNode?>,
        val headB: List<ListNode?>,
        val result: ListNode?,
    )

    @Test
    fun getIntersectionNode() {
        val tests =
            listOf(
                IntersectionOfTwoLinkedListsTestData(
                    headA =
                        listOf(
                            basicSingleListNode[1][4],
                            basicSingleListNode[1][1],
                            basicSingleListNode[0][8],
                            basicSingleListNode[0][4],
                            basicSingleListNode[0][5],
                        ),
                    headB =
                        listOf(
                            basicSingleListNode[2][5],
                            basicSingleListNode[2][6],
                            basicSingleListNode[2][1],
                            basicSingleListNode[0][8],
                            basicSingleListNode[0][4],
                            basicSingleListNode[0][5],
                        ),
                    result = basicSingleListNode[0][8],
                ),
                IntersectionOfTwoLinkedListsTestData(
                    headA =
                        listOf(
                            basicSingleListNode[1][1],
                            basicSingleListNode[1][9],
                            basicSingleListNode[2][1],
                            basicSingleListNode[0][2],
                            basicSingleListNode[0][4],
                        ),
                    headB =
                        listOf(
                            basicSingleListNode[2][3],
                            basicSingleListNode[0][2],
                            basicSingleListNode[0][4],
                        ),
                    result = basicSingleListNode[0][2],
                ),
                IntersectionOfTwoLinkedListsTestData(
                    headA =
                        listOf(
                            basicSingleListNode[0][2],
                            basicSingleListNode[0][6],
                            basicSingleListNode[0][4],
                        ),
                    headB = listOf(basicSingleListNode[0][1], basicSingleListNode[0][5]),
                    result = null,
                ),
            )
        tests.forEach { test ->
            val headA = ListNodeUtil.connectListNode(test.headA)
            val headB = ListNodeUtil.connectListNode(test.headB)
            assertEquals(
                intersectionOfTwoLinkedLists.getIntersectionNode(headA, headB),
                test.result,
            )
            ListNodeUtil.clearBasicSingleListNode(basicSingleListNode)
        }
    }
}
