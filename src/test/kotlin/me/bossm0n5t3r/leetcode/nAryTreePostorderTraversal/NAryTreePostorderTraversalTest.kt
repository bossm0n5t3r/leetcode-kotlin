package me.bossm0n5t3r.leetcode.nAryTreePostorderTraversal

import me.bossm0n5t3r.leetcode.utils.Node
import me.bossm0n5t3r.leetcode.utils.NodeUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NAryTreePostorderTraversalTest {
    private val sut = NAryTreePostorderTraversal.Solution()

    private data class TestData(val root: Node?, val result: List<Int>)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    NodeUtil.generateNodeOrNull(1, null, 3, 2, 4, null, 5, 6),
                    listOf(5, 6, 3, 2, 4, 1),
                ),
                TestData(
                    NodeUtil.generateNodeOrNull(
                        1,
                        null,
                        2,
                        3,
                        4,
                        5,
                        null,
                        null,
                        6,
                        7,
                        null,
                        8,
                        null,
                        9,
                        10,
                        null,
                        null,
                        11,
                        null,
                        12,
                        null,
                        13,
                        null,
                        null,
                        14,
                    ),
                    listOf(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1),
                ),
            )

        tests.forEach { test -> assertEquals(test.result, sut.postorder(test.root)) }
    }
}
