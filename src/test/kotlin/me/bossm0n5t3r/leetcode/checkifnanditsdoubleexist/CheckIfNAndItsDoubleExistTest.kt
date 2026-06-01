package me.bossm0n5t3r.leetcode.checkifnanditsdoubleexist

import me.bossm0n5t3r.leetcode.utils.StringUtil.toIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfNAndItsDoubleExistTest {
    private val sut = CheckIfNAndItsDoubleExist.Solution()

    private data class TestData(val arr: IntArray, val result: Boolean) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (result != other.result) return false
            if (!arr.contentEquals(other.arr)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = result.hashCode()
            result1 = 31 * result1 + arr.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData("[10,2,5,3]".toIntArray(), true),
                TestData("[3,1,7,11]".toIntArray(), false),
            )

        for (testData in testDataList) {
            assertEquals(testData.result, sut.checkIfExist(testData.arr))
        }
    }
}
