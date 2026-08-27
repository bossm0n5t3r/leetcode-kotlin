package me.bossm0n5t3r.leetcode.clonegraph

import me.bossm0n5t3r.leetcode.utils.Node
import me.bossm0n5t3r.leetcode.utils.NodeUtil
import me.bossm0n5t3r.leetcode.utils.NodeUtil.toList
import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CloneGraphTest {
    private val sut = CloneGraph.Solution()

    private data class TestData(val node: Node?)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    NodeUtil.generateNodeOrNull("[[2,4],[1,3],[2,4],[1,3]]".toListOfIntList())
                ),
                TestData(NodeUtil.generateNodeOrNull("[[]]".toListOfIntList())),
                TestData(NodeUtil.generateNodeOrNull("[]".toListOfIntList())),
            )

        tests.forEach { test ->
            assertEquals(test.node?.toList(), sut.cloneGraph(test.node)?.toList())
        }
    }
}
