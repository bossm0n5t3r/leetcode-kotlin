package me.bossm0n5t3r.leetcode.rotateArray

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RotateArrayTest {
    private val sut = RotateArray.Solution()

    private data class TestData(val nums: IntArray, val k: Int, val result: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!nums.contentEquals(other.nums)) return false
            if (k != other.k) return false
            if (!result.contentEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = nums.contentHashCode()
            result1 = 31 * result1 + k
            result1 = 31 * result1 + result.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("[1,2,3,4,5,6,7]".toIntArray(), 3, "[5,6,7,1,2,3,4]".toIntArray()),
                TestData("[-1,-100,3,99]".toIntArray(), 2, "[3,99,-1,-100]".toIntArray()),
            )

        tests.forEach { test ->
            val (nums, k, result) = test
            val copiedNumsOne = nums.copyOf()
            sut.rotateOne(copiedNumsOne, k)
            assertTrue { copiedNumsOne.contentEquals(result) }

            val copiedNumsTwo = nums.copyOf()
            sut.rotateTwo(copiedNumsTwo, k)
            assertTrue { copiedNumsTwo.contentEquals(result) }

            val copiedNumsThree = nums.copyOf()
            sut.rotateThree(copiedNumsThree, k)
            assertTrue { copiedNumsThree.contentEquals(result) }
        }
    }
}
