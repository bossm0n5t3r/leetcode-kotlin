package me.bossm0n5t3r.leetcode.processTasksUsingServers

import java.util.PriorityQueue

class ProcessTasksUsingServers {
    class Solution {
        fun assignTasks(servers: IntArray, tasks: IntArray): IntArray {
            val freeServers =
                PriorityQueue<Server> { a, b ->
                    if (a.weight != b.weight) {
                        a.weight - b.weight
                    } else {
                        a.index - b.index
                    }
                }
            servers.forEachIndexed { serverIndex, serverWeight ->
                freeServers.add(Server(serverIndex, serverWeight))
            }
            val workingServers =
                PriorityQueue<Server> { a, b ->
                    if (a.task != b.task) {
                        a.task - b.task
                    } else if (a.weight != b.weight) {
                        a.weight - b.weight
                    } else {
                        a.index - b.index
                    }
                }
            val result = IntArray(tasks.size) { 0 }
            tasks.forEachIndexed { index, task ->
                while (workingServers.isNotEmpty() && workingServers.peek().task <= index) {
                    freeServers.add(workingServers.poll())
                }
                if (freeServers.isNotEmpty()) {
                    val server = freeServers.poll()
                    server.task = index + task
                    workingServers.add(server)
                    result[index] = server.index
                } else {
                    val server = workingServers.poll()
                    server.task += task
                    workingServers.add(server)
                    result[index] = server.index
                }
            }
            return result
        }

        private data class Server(val index: Int, val weight: Int, var task: Int = 0)
    }
}
