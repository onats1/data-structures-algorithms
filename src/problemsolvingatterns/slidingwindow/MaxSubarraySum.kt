package problemsolvingatterns.slidingwindow

import kotlin.math.max

/**
 * Write a function called maxSubarraySum which accepts an array of integers and a number called n.
 * The function should calculate the maximum sum of n consecutive elements in the array.
 * */
fun maxSubarraySum(arr: List<Int>, num: Int): Int? {
    if (arr.size < num) {
        return null
    }
    var max = Int.MIN_VALUE
    //N.B until iterates your loop until but excluding the specified limit.
    for (i in 0 until arr.size - num) {
        var tempStore = 0
        for (j in 0 until num) {
            tempStore += arr[i + j]
        }
        if (tempStore > max) {
            max = tempStore
        }
    }
    return max
}

fun maxSubArraySumOptimized(arr: List<Int>, num: Int): Int? {
    var maxSum: Int
    var tempSum = 0
    if (num > arr.size) {
        return null
    }
    for (i in 0 until num) {
        tempSum += arr[i]
    }
    maxSum = tempSum
    for (i in num until arr.size) {
        tempSum = tempSum - arr[i - num] + arr[i]
        maxSum = max(maxSum, tempSum)
    }
    return maxSum
}

fun main() {
    val result = maxSubArraySumOptimized(listOf(2,6,9,2,1,8,5,6,3),3)
    print(result)
}