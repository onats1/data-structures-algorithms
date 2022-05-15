package sortingalgorithms

fun selectionSort(arr: MutableList<Int>): List<Int> {
    for (i in 0 until arr.size) {
        var lowest = i
        for (j in i+1 until arr.size) {
            if (arr[j] < arr[lowest]) {
                lowest = j
            }
        }
        if (i != lowest) {
            val temp = arr[i]
            arr[i] = arr[lowest]
            arr[lowest] = temp
        }
    }
    return arr
}

fun main() {
    val list = mutableListOf<Int>()
    for (i in 0 until 10) {
        val number = (0..30).random()
        list.add(number)
    }
    print(selectionSort(list))
}