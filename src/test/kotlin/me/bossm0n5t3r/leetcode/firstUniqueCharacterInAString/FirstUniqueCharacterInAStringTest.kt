package me.bossm0n5t3r.leetcode.firstUniqueCharacterInAString

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstUniqueCharacterInAStringTest {
    private val firstUniqueCharacterInAString = FirstUniqueCharacterInAString.Solution()

    data class FirstUniqueCharacterInAStringTestData(val s: String, val result: Int)

    @Test
    fun firstUniqChar() {
        val tests =
            listOf(
                FirstUniqueCharacterInAStringTestData("leetcode", 0),
                FirstUniqueCharacterInAStringTestData("loveleetcode", 2),
                FirstUniqueCharacterInAStringTestData("aabb", -1),
            )

        tests.forEach { test ->
            assertEquals(firstUniqueCharacterInAString.firstUniqChar(test.s), test.result)
        }
    }
}
