package me.bossm0n5t3r.leetcode.relativeSortArray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RelativeSortArrayTest {
    private val sut = RelativeSortArray.Solution()

    private data class TestData(val arr1: IntArray, val arr2: IntArray, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!arr1.contentEquals(other.arr1)) return false
            if (!arr2.contentEquals(other.arr2)) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = arr1.contentHashCode()
            result1 = 31 * result1 + arr2.contentHashCode()
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "[2,3,1,3,2,4,6,7,9,2,19]".toIntArray(),
                    "[2,1,4,3,9,6]".toIntArray(),
                    "[2,2,2,1,4,3,3,9,6,7,19]".toIntArray(),
                ),
                TestData(
                    "[28,6,22,8,44,17]".toIntArray(),
                    "[22,28,8,6]".toIntArray(),
                    "[22,28,8,6,17,44]".toIntArray(),
                ),
            )

        tests.forEach { test ->
            assertTrue {
                sut.relativeSortArray(test.arr1, test.arr2).contentEquals(test.result)
                sut.relativeSortArrayUsingCountingSort(test.arr1, test.arr2)
                    .contentEquals(test.result)
            }
        }
    }
}
