package sortingalgorithms

fun bubbleSort(list: MutableList<Int>): List<Int> {
    var noSwaps: Boolean
    for (i in 0 until list.size) {
        noSwaps = true
        for (j in 0 until list.size - 1) {
            if (list[j] > list[j + 1]) {
                val lower = list[j]
                list[j] = list[j + 1]
                list[j + 1] = lower
                noSwaps = false
            }
        }
        if (noSwaps) break
    }
    return list
}

fun main() {
    val list = mutableListOf<Int>()
    for (i in 0 until 10) {
        val number = (0..30).random()
        list.add(number)
    }
    print(bubbleSort(list))
}