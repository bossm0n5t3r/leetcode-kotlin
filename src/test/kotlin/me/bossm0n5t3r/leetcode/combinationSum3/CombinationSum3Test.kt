package me.bossm0n5t3r.leetcode.combinationSum3

import me.bossm0n5t3r.leetcode.utils.StringUtil.toListOfIntList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationSum3Test {
    private val sut = CombinationSum3.Solution()

    private data class TestData(val k: Int, val n: Int, val result: List<List<Int>>)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(3, 7, "[[1,2,4]]".toListOfIntList()),
                TestData(3, 9, "[[1,2,6],[1,3,5],[2,3,4]]".toListOfIntList()),
                TestData(4, 1, "[]".toListOfIntList()),
            )

        tests.forEach { test -> assertEquals(sut.combinationSum3(test.k, test.n), test.result) }
    }
}
