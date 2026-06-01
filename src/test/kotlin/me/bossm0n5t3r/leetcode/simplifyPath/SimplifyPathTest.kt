package me.bossm0n5t3r.leetcode.simplifyPath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimplifyPathTest {
    private val sut = SimplifyPath.Solution()

    private data class TestData(val path: String, val result: String)

    @Test
    fun test() {
        val tests =
            listOf(
                TestData("/home/", "/home"),
                TestData("/home//foo/", "/home/foo"),
                TestData("/home/user/Documents/../Pictures", "/home/user/Pictures"),
                TestData("/.../a/../b/c/../d/./", "/.../b/d"),
                TestData("/../", "/"),
            )

        tests.forEach { test -> assertEquals(test.result, sut.simplifyPath(test.path)) }
    }
}
