package me.bossm0n5t3r.leetcode.onlineStockSpan

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OnlineStockSpanTest {
    private val sut = OnlineStockSpan.StockSpanner()

    @Test
    fun test() {
        assertEquals(1, sut.next(100))
        assertEquals(1, sut.next(80))
        assertEquals(1, sut.next(60))
        assertEquals(2, sut.next(70))
        assertEquals(1, sut.next(60))
        assertEquals(4, sut.next(75))
        assertEquals(6, sut.next(85))
    }
}
