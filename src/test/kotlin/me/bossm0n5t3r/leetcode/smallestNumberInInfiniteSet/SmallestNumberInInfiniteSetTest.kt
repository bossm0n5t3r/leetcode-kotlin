package me.bossm0n5t3r.leetcode.smallestNumberInInfiniteSet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestNumberInInfiniteSetTest {
    @Test
    fun test() {
        val sut = SmallestNumberInInfiniteSet.SmallestInfiniteSet()

        assertEquals(Unit, sut.addBack(2))
        assertEquals(1, sut.popSmallest())
        assertEquals(2, sut.popSmallest())
        assertEquals(3, sut.popSmallest())
        assertEquals(Unit, sut.addBack(1))
        assertEquals(1, sut.popSmallest())
        assertEquals(4, sut.popSmallest())
        assertEquals(5, sut.popSmallest())
    }
}
