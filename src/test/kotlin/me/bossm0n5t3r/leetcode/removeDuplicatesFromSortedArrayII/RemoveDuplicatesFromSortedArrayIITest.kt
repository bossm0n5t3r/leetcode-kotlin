package me.bossm0n5t3r.leetcode.removeDuplicatesFromSortedArrayII

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayIITest {
    private val sut = RemoveDuplicatesFromSortedArrayII.Solution()

    private data class TestData(val nums: IntArray, val result: Int, val resultNumList: List<Int>)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[1,1,1,2,2,3]".toIntArray(), 5, listOf(1, 1, 2, 2, 3)),
                TestData("[0,0,1,1,1,1,2,3,3]".toIntArray(), 7, listOf(0, 0, 1, 1, 2, 3, 3)),
            )

        tests.forEach { test ->
            val result = sut.removeDuplicates(test.nums)
            assertEquals(test.result, result)
            assertThat(test.nums.take(result)).isEqualTo(test.resultNumList)
        }
    }
}
