package me.bossm0n5t3r.leetcode.productofarrayexceptself

class ProductOfArrayExceptSelf {
    class Solution {
        // You must write an algorithm that runs in O(n) time and without using the division
        // operation.
        // O(1) extra space complexity
        fun productExceptSelf(nums: IntArray): IntArray {
            val (numOfZeroes, productOfArrayExceptZeroes) =
                getNumOfZeroesAndProductOfArrayExceptZeroes(nums)
            return when (numOfZeroes) {
                0 -> {
                    val result = IntArray(nums.size)
                    nums.forEachIndexed { index, i ->
                        result[index] = (productOfArrayExceptZeroes / i).toInt()
                    }
                    result
                }

                1 -> {
                    val result = IntArray(nums.size)
                    for (i in nums.indices) {
                        if (nums[i] == 0) {
                            result[i] = productOfArrayExceptZeroes.toInt()
                            break
                        }
                    }
                    result
                }

                else -> {
                    IntArray(nums.size)
                }
            }
        }

        private fun getNumOfZeroesAndProductOfArrayExceptZeroes(nums: IntArray): Pair<Int, Long> {
            var numOfZeroes = 0
            var productOfArrayExceptZeroes: Long = 1
            nums.forEach { num ->
                when (num) {
                    0 -> {
                        numOfZeroes++
                        if (numOfZeroes == 2) {
                            return Pair(numOfZeroes, 0)
                        }
                    }

                    else -> {
                        productOfArrayExceptZeroes *= num
                    }
                }
            }
            return Pair(numOfZeroes, productOfArrayExceptZeroes)
        }

        fun productExceptSelfAt20230707(nums: IntArray): IntArray {
            val countZero = nums.count { it == 0 }
            if (countZero > 1) return IntArray(nums.size) { 0 }

            val result = IntArray(nums.size) { 0 }
            var total = 1L
            var zeroIdx = -1
            for (i in nums.indices) {
                val num = nums[i]
                if (num != 0) {
                    total *= num
                } else {
                    zeroIdx = i
                }
            }
            return if (countZero == 1) {
                result[zeroIdx] = total.toInt()
                result
            } else {
                for (i in nums.indices) {
                    result[i] = (total / nums[i]).toInt()
                }
                result
            }
        }

        fun productExceptSelfAt20250104(nums: IntArray): IntArray {
            var zeroIndex = -1
            var product = 1L
            for (i in nums.indices) {
                if (nums[i] == 0) {
                    if (zeroIndex != -1) {
                        return IntArray(nums.size)
                    }
                    zeroIndex = i
                    continue
                }
                product *= nums[i]
            }
            return if (zeroIndex != -1) {
                val result = IntArray(nums.size)
                result[zeroIndex] = product.toInt()
                result
            } else {
                val result = IntArray(nums.size) { product.toInt() }
                for (i in nums.indices) {
                    result[i] /= nums[i]
                }
                result
            }
        }
    }
}
