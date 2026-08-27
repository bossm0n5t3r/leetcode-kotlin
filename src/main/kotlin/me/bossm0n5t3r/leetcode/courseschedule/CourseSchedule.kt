package me.bossm0n5t3r.leetcode.courseschedule

class CourseSchedule {
    class Solution {
        fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
            val prerequisitesMap = mutableMapOf<Int, MutableList<Int>>()

            for (prerequisite in prerequisites) {
                val (a, b) = prerequisite
                prerequisitesMap[a] =
                    prerequisitesMap.getOrDefault(a, mutableListOf()).apply { add(b) }
            }

            // 0: 방문 안 함
            // 1: 현재 탐색 중
            // 2: 탐색 완료
            val visited = IntArray(numCourses)

            for (course in 0 until numCourses) {
                if (!dfs(prerequisitesMap, visited, course)) {
                    return false
                }
            }

            return true
        }

        private fun dfs(
            prerequisitesMap: Map<Int, List<Int>>,
            visited: IntArray,
            course: Int,
        ): Boolean {
            if (visited[course] == 1) {
                return false
            }

            if (visited[course] == 2) {
                return true
            }

            visited[course] = 1

            for (prerequisite in prerequisitesMap[course].orEmpty()) {
                if (!dfs(prerequisitesMap, visited, prerequisite)) {
                    return false
                }
            }

            visited[course] = 2

            return true
        }
    }
}
