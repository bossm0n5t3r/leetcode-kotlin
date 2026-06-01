package me.bossm0n5t3r.leetcode.spiralMatrixIV

import me.bossm0n5t3r.leetcode.utils.ListNode
import me.bossm0n5t3r.leetcode.utils.ListNodeUtil
import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SpiralMatrixIVTest {
    private val sut = SpiralMatrixIV.Solution()

    private data class TestData(
        val m: Int,
        val n: Int,
        val head: ListNode?,
        val result: Array<IntArray>,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (m != other.m) return false
            if (n != other.n) return false
            if (head != other.head) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = m
            result1 = 31 * result1 + n
            result1 = 31 * result1 + (head?.hashCode() ?: 0)
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    3,
                    5,
                    ListNodeUtil.generateListNode(3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0),
                    "[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]".toArrayOfIntArray(),
                ),
                TestData(
                    1,
                    4,
                    ListNodeUtil.generateListNode(0, 1, 2),
                    "[[0,1,2,-1]]".toArrayOfIntArray(),
                ),
            )

        tests.forEach { test ->
            assertTrue {
                sut.spiralMatrix(test.m, test.n, test.head).contentDeepEquals(test.result)
            }
        }
    }
}
