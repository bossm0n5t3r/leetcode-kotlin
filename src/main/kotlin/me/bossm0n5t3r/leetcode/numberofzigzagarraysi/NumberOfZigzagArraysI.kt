package me.bossm0n5t3r.leetcode.numberofzigzagarraysi

class NumberOfZigzagArraysI {
    class Solution {
        fun zigZagArrays(n: Int, l: Int, r: Int): Int {
            val mod = 1_000_000_007
            val m = r - l + 1

            // 실제 값 자체보다 값들 사이의 대소관계만 중요
            // 예를 들어 l = 4, r = 6이면 값은 4, 5, 6이지만,
            // 계산에서는 0, 1, 2 인덱스로 압축해서 다룰 수 있음
            //
            // up[i]   = 마지막 값이 i이고, 직전 값보다 커져서 끝나는 배열 개수
            // down[i] = 마지막 값이 i이고, 직전 값보다 작아져서 끝나는 배열 개수
            //
            // ZigZag 조건상 방향은 매번 바뀌어야 하므로,
            // up 상태 다음에는 down 상태만 올 수 있고,
            // down 상태 다음에는 up 상태만 올 수 있음

            if (n == 1) return m

            var up = IntArray(m)
            var down = IntArray(m)

            // 길이 2 초기화
            // 마지막 값이 i일 때:
            // - up[i]은 이전 값이 i보다 작은 경우의 수 = i
            // - down[i]은 이전 값이 i보다 큰 경우의 수 = m - i - 1
            //
            // 예: m = 3, 가능한 인덱스가 0, 1, 2라면
            // up   = [0, 1, 2]
            // down = [2, 1, 0]
            for (i in 0 until m) {
                up[i] = i
                down[i] = m - i - 1
            }

            // 길이 2까지는 초기화했으므로, 남은 n - 2번 동안 길이를 하나씩 늘림
            repeat(n - 2) {
                val newUp = IntArray(m)
                val newDown = IntArray(m)

                // newUp[i]는 이번에 상승해서 마지막 값이 i가 되는 경우의 수
                // 직전 값은 i보다 작아야 하고, 직전 방향은 down이어야 함
                //
                // newUp[i] = down[0] + down[1] + ... + down[i - 1]
                //
                // 매번 직접 합을 구하면 O(m^2)이 되므로 prefix 누적합으로 O(m)에 처리
                var prefix = 0
                for (i in 0 until m) {
                    newUp[i] = prefix
                    prefix = (prefix + down[i]) % mod
                }

                // newDown[i]는 이번에 하강해서 마지막 값이 i가 되는 경우의 수
                // 직전 값은 i보다 커야 하고, 직전 방향은 up이어야 함
                //
                // newDown[i] = up[i + 1] + up[i + 2] + ... + up[m - 1]
                //
                // 오른쪽에서 왼쪽으로 suffix 누적합을 만들면 O(m)에 처리
                var suffix = 0
                for (i in m - 1 downTo 0) {
                    newDown[i] = suffix
                    suffix = (suffix + up[i]) % mod
                }

                up = newUp
                down = newDown
            }

            // 길이 n의 ZigZag 배열은 마지막 방향이 상승일 수도 있고 하강일 수도 있으므로,
            // up과 down에 남아 있는 모든 경우의 수를 더함
            //
            // 예: n = 3, l = 1, r = 3이면 m = 3
            // 길이 2 초기값:
            // up   = [0, 1, 2]
            // down = [2, 1, 0]
            //
            // 길이 3으로 확장:
            // newUp   = [0, 2, 3]
            // newDown = [3, 2, 0]
            //
            // 결과 = 0 + 2 + 3 + 3 + 2 + 0 = 10
            var result = 0
            for (count in up) result = (result + count) % mod
            for (count in down) result = (result + count) % mod

            return result
        }
    }
}
