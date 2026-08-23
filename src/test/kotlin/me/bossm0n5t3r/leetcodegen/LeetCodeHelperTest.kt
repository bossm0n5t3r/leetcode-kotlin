package me.bossm0n5t3r.leetcodegen

import me.bossm0n5t3r.leetcodegen.LeetCodeHelper.toLowerCase
import me.bossm0n5t3r.leetcodegen.LeetCodeHelper.toPascalCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeetCodeHelperTest {
    @Test
    fun `leading title digits become words for package and class names`() {
        val problemName = "15. 3Sum"

        assertEquals("threesum", problemName.toLowerCase())
        assertEquals("ThreeSum", problemName.toPascalCase())
    }

    @Test
    fun `multiple leading digits each become words`() {
        val problemName = "123Pattern"

        assertEquals("onetwothreepattern", problemName.toLowerCase())
        assertEquals("OneTwoThreePattern", problemName.toPascalCase())
    }
}
