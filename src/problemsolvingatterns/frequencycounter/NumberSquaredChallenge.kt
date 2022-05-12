package problemsolvingatterns.frequencycounter

/**
 * Write a function to compare two arrays of numbers. It should return true if the second array contains the
 * square of each number in the first array.
 * */

fun Int.pow(): Int {
    return this * this
}

//Bad / Inefficient method O(n^2)
fun same(arr1: ArrayList<Int>, arr2: ArrayList<Int>): Boolean {
    if (arr1.size != arr2.size) {
        return false
    }
    arr1.forEach { number ->
        val currentIndex = arr2.indexOf(number.pow())
        if (currentIndex == -1) { // If at any iteration, current index is not found.
            return false
        }
        arr2.remove(arr2[currentIndex])
    }
    return true
}

// Optimized solution using frequency conter method. O(n)
fun sameOptimized(arr1: ArrayList<Int>, arr2: ArrayList<Int>): Boolean {

    if (arr1.size != arr2.size) {
        return false
    }

    val store1 = mutableMapOf<Int, Int>()
    val store2 = mutableMapOf<Int, Int>()

    arr1.forEach { number ->
        store1[number] = store1[number]?:0 + 1
    }
    arr2.forEach { number ->
        store2[number] = store2[number]?:0 + 1
    }

    store1.forEach { (key, _) ->
        if (!store2.containsKey(key.pow())) {
            return false
        }
        if (store2[key.pow()] != store1[key]) {
            return false
        }
    }
    return true
}