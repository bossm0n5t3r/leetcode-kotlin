package me.bossm0n5t3r.leetcode.findmedianfromdatastream

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMedianFromDataStreamTest {
    private val sut = FindMedianFromDataStream.MedianFinder()

    @Test
    fun test() {
        sut.addNum(1)
        sut.addNum(2)
        assertEquals(1.5, sut.findMedian())
        sut.addNum(3)
        assertEquals(2.0, sut.findMedian())
    }
}
