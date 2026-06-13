package me.bossm0n5t3r.leetcode.pascalsTriangle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PascalsTriangleTest {
    private val pascalsTriangle = PascalsTriangle.Solution()

    data class PascalsTriangleTestData(val numsRow: Int, val result: List<List<Int>>)

    @Test
    fun generate() {
        val tests =
            listOf(
                PascalsTriangleTestData(
                    5,
                    listOf(
                        listOf(1),
                        listOf(1, 1),
                        listOf(1, 2, 1),
                        listOf(1, 3, 3, 1),
                        listOf(1, 4, 6, 4, 1),
                    ),
                ),
                PascalsTriangleTestData(1, listOf(listOf(1))),
            )
        tests.forEach { test -> assertEquals(test.result, pascalsTriangle.generate(test.numsRow)) }
    }
}
