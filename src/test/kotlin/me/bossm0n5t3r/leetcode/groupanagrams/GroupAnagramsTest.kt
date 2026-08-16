package me.bossm0n5t3r.leetcode.groupanagrams

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GroupAnagramsTest {
    private val groupAnagrams = GroupAnagrams.Solution()

    data class GroupAnagramsTestData(val strs: Array<String>, val result: List<List<String>>) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as GroupAnagramsTestData

            if (!strs.contentEquals(other.strs)) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = strs.contentHashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun groupAnagrams() {
        val tests =
            listOf(
                GroupAnagramsTestData(
                    arrayOf("eat", "tea", "tan", "ate", "nat", "bat"),
                    listOf(listOf("bat"), listOf("nat", "tan"), listOf("ate", "eat", "tea")),
                ),
                GroupAnagramsTestData(arrayOf(""), listOf(listOf(""))),
                GroupAnagramsTestData(arrayOf("a"), listOf(listOf("a"))),
                GroupAnagramsTestData(
                    arrayOf("ddddddddddg", "dgggggggggg"),
                    listOf(listOf("ddddddddddg"), listOf("dgggggggggg")),
                ),
            )
        tests.forEach { test ->
            assertTrue(groupAnagrams.groupAnagrams(test.strs).isEqualTo(test.result))
        }
    }

    private fun List<List<String>>.isEqualTo(other: List<List<String>>): Boolean {
        if (this.size != other.size) return false
        val sortedThis = this.map { it.sorted() }.sortedBy { it.first() }.sortedBy { it.size }
        val sortedOther = other.map { it.sorted() }.sortedBy { it.first() }.sortedBy { it.size }
        sortedThis.forEachIndexed { index, strings ->
            strings.forEachIndexed { indexInString, s ->
                if (s != sortedOther[index][indexInString]) {
                    return false
                }
            }
        }
        return true
    }
}
