package me.bossm0n5t3r.leetcode.networkrecoverypathways

import me.bossm0n5t3r.leetcode.utils.StringUtil.toArrayOfIntArray
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NetworkRecoveryPathwaysTest {
    private val sut = NetworkRecoveryPathways.Solution()

    private data class TestData(
        val edges: Array<IntArray>,
        val online: BooleanArray,
        val k: Long,
        val result: Int,
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (k != other.k) return false
            if (result != other.result) return false
            if (!edges.contentDeepEquals(other.edges)) return false
            if (!online.contentEquals(other.online)) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = k.hashCode()
            result1 = 31 * result1 + result
            result1 = 31 * result1 + edges.contentDeepHashCode()
            result1 = 31 * result1 + online.contentHashCode()
            return result1
        }
    }

    @Test
    fun test() {
        val testDataList =
            listOf(
                TestData(
                    "[[0,1,5],[1,3,10],[0,2,3],[2,3,4]]".toArrayOfIntArray(),
                    booleanArrayOf(true, true, true, true),
                    10,
                    3,
                ),
                TestData(
                    "[[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]]".toArrayOfIntArray(),
                    booleanArrayOf(true, true, true, false, true),
                    12,
                    6,
                ),
            )

        for (testData in testDataList) {
            assertEquals(
                testData.result,
                sut.findMaxPathScore(testData.edges, testData.online, testData.k),
            )
        }
    }
}
