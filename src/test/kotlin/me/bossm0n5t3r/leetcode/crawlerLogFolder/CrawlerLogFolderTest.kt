package me.bossm0n5t3r.leetcode.crawlerLogFolder

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CrawlerLogFolderTest {
    private val sut = CrawlerLogFolder.Solution()

    private data class TestData(val logs: Array<String>, val result: Int) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as TestData

            if (!logs.contentEquals(other.logs)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = logs.contentHashCode()
            result1 = 31 * result1 + result
            return result1
        }
    }

    @Test
    fun test() {
        val tests =
            listOf(
                TestData(arrayOf("d1/", "d2/", "../", "d21/", "./"), 2),
                TestData(arrayOf("d1/", "d2/", "./", "d3/", "../", "d31/"), 3),
                TestData(arrayOf("d1/", "../", "../", "../"), 0),
            )

        tests.forEach { test -> assertEquals(test.result, sut.minOperations(test.logs)) }
    }
}
