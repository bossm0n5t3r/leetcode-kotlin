package me.bossm0n5t3r.leetcode.findAllGroupsOfFarmland

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindAllGroupsOfFarmlandTest {
    private val sut = FindAllGroupsOfFarmland.Solution()

    private data class TestData(val land: Array<IntArray>, val result: Array<IntArray>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!land.contentDeepEquals(other.land)) return false
            if (!result.contentDeepEquals(other.result)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = land.contentDeepHashCode()
            result1 = 31 * result1 + result.contentDeepHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(
                    "[[1,0,0],[0,1,1],[0,1,1]]".toArrayOfIntArray(),
                    "[[0,0,0,0],[1,1,2,2]]".toArrayOfIntArray(),
                ),
                TestData("[[1,1],[1,1]]".toArrayOfIntArray(), "[[0,0,1,1]]".toArrayOfIntArray()),
                TestData("[[0]]".toArrayOfIntArray(), "[]".toArrayOfIntArray()),
            )

        tests.forEach { test ->
            assertTrue { test.result.contentDeepEquals(sut.findFarmland(test.land)) }
        }
    }
}
