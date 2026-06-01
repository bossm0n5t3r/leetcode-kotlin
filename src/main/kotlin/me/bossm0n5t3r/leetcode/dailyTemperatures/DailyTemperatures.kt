package me.bossm0n5t3r.leetcode.dailyTemperatures

import java.util.ArrayDeque
import java.util.Deque

class DailyTemperatures {
    class Solution {
        fun dailyTemperatures(temperatures: IntArray): IntArray {
            // Initialize a deque to store indices of temperatures.
            val deque: Deque<Int> = ArrayDeque()

            // Initialize a result vector to store the days until a warmer temperature is
            // encountered.
            val result = IntArray(temperatures.size)

            // Iterate through the temperatures in reverse order.
            for (i in temperatures.lastIndex downTo 0) {
                // If the deque is empty, push the current index and set the result for that index
                // to 0.
                if (deque.isEmpty()) {
                    deque.offerFirst(i)
                    result[i] = 0
                    continue
                }

                // If the deque is not empty,
                // pop indices from the front of the deque
                // while the current temperature is greater than or equal to the temperature at the
                // front.
                while (deque.isNotEmpty() && temperatures[deque.peekFirst()] <= temperatures[i]) {
                    deque.pollFirst()
                }

                result[i] =
                    if (deque.isEmpty()) {
                        // If the deque is empty after the above step, set the result for the
                        // current index to 0.
                        0
                    } else {
                        // If the deque is not empty,
                        // set the result for the current index to the difference
                        // between the front of the deque and the current index.
                        deque.peekFirst() - i
                    }

                // Push the current index to the front of the deque.
                deque.offerFirst(i)
            }

            // Continue these steps for all temperatures.
            // Return the result vector.
            return result
        }
    }
}
