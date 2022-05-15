package sortingalgorithms

fun insertionSort(arr: MutableList<Int>): List<Int> {
    if (arr.isEmpty() || arr.size < 2) {
        return arr
    }
    for (count in 1 until arr.size) {
        val item = arr[count]
        var i = count
        while (i > 0 && item < arr[i - 1]) {
            arr[i] = arr[i - 1]
            i -= 1
        }
        arr[i] = item
    }
    return arr
}