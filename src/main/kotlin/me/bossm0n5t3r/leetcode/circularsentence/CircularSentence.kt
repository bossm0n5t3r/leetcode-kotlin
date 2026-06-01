package me.bossm0n5t3r.leetcode.circularsentence

class CircularSentence {
    class Solution {
        fun isCircularSentence(sentence: String): Boolean =
            sentence.last() == sentence.first() &&
                sentence.split(" ").windowed(2).all { it.first().last() == it.last().first() }
    }
}
