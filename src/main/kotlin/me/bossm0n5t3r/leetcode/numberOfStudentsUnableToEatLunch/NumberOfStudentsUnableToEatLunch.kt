package me.bossm0n5t3r.leetcode.numberOfStudentsUnableToEatLunch

import java.util.LinkedList
import java.util.Queue

class NumberOfStudentsUnableToEatLunch {
    class Solution {
        fun countStudents(students: IntArray, sandwiches: IntArray): Int {
            val numberOfStudents = IntArray(2) { 0 }
            val studentQueue: Queue<Int> = LinkedList()
            for (student in students) {
                studentQueue.offer(student)
                numberOfStudents[student]++
            }
            val sandwichQueue: Queue<Int> = LinkedList(sandwiches.toList())

            while (sandwichQueue.isNotEmpty() && numberOfStudents[sandwichQueue.peek()] > 0) {
                val currentStudent = studentQueue.poll()
                if (currentStudent == sandwichQueue.peek()) {
                    sandwichQueue.poll()
                    numberOfStudents[currentStudent]--
                } else {
                    studentQueue.offer(currentStudent)
                }
            }
            return studentQueue.size
        }
    }
}
