package me.bossm0n5t3r.leetcode.asteroidCollision

import java.util.Stack

class AsteroidCollision {
    class Solution {
        fun asteroidCollision(asteroids: IntArray): IntArray {
            val stack = Stack<Int>()
            for (asteroid in asteroids) {
                if (stack.isEmpty()) {
                    stack.push(asteroid)
                } else {
                    collision(stack, asteroid)
                }
            }
            return stack.toIntArray()
        }

        private fun collision(stack: Stack<Int>, asteroid: Int) {
            if (stack.isNotEmpty() && stack.peek() > 0 && asteroid < 0) {
                val peek = stack.peek()
                if (peek + asteroid <= 0) {
                    stack.pop()
                    if (peek + asteroid < 0) {
                        collision(stack, asteroid)
                    }
                }
            } else {
                stack.push(asteroid)
                return
            }
        }
    }
}
