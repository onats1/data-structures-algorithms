package problemsolvingatterns.multiplepointers

/**
 * Write a function called sumZero which accepts a sorted array of integers. The function
 * should find the first pair that sums to zero. Return a pair that contains the numbers or
 * undefined if there are no pairs found.
 * */
fun sumZero(arr: List<Int>): Pair<Int, Int>? {
    var left = 0
    var right = arr.size - 1
    var result: Pair<Int, Int>? = null
    while (left < right) {
        val sum = arr[left] + arr[right]
        if (sum == 0) {
            result = Pair(arr[left], arr[right])
            break
        } else if (sum > 0) {
            right--
        } else {
            left++
        }
    }
    return result
}

fun main() {
    val result = sumZero(listOf(-3,-2,-1,0,1,2,6))
    print(result)
}
