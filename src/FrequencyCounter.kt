
/**
 * Write a function to compare two arrays of numbers. It should return true if the second array contains the
 * square of each number in the first array.
 * */

fun Int.pow(): Int{
    return this * this
}

//Bad / Inefficient method O(n^2)
fun same(arr1: ArrayList<Int>, arr2: ArrayList<Int>): Boolean {
    if (arr1.size != arr2.size) {
        return false
    }
    arr1.forEachIndexed { position, number ->
        val correctIndex = arr2.indexOf(number.pow())
        if (correctIndex == -1) {
            return false
        }
        arr2.remove(arr2[correctIndex])
    }
    return true
}

// Optimized solution using frequency conter method.
fun sameOptimized(arr1: ArrayList<Int>, arr2: ArrayList<Int>): Boolean {
    if (arr1.size != arr2.size) {
        return false
    }

    val frequencyCounter1 = hashMapOf<Int, Int>()
    val frequencyCounter2 = hashMapOf<Int, Int>()

    arr1.forEach { number ->
        frequencyCounter1[number] = frequencyCounter1[number]?:0 + 1
    }
    arr2.forEach { number ->
        frequencyCounter2[number] = frequencyCounter2[number]?:0 + 1
    }
    frequencyCounter1.forEach { (key, value) ->
        if (frequencyCounter2[key.pow()] != value) {
            return false
        }
    }
    return true
}

fun main() {
    val firstArray = arrayListOf(1, 3, 4)
    val secondArray = arrayListOf(1, 16, 9)

    val result = sameOptimized(firstArray, secondArray)
    println(result)
}