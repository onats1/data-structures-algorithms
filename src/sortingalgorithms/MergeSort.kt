package sortingalgorithms

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size <= 1) {
        return list
    }

    val middle = list.size / 2
    val left = list.subList(0, middle);
    val right = list.subList(middle, list.size);

    return mergeArrays(mergeSort(left), mergeSort(right))
}

fun mergeArrays(left: List<Int>, right: List<Int>): List<Int>  {
    var leftIdx = 0
    var rightIdx = 0
    val mergedList : MutableList<Int> = mutableListOf()

    while (leftIdx < left.size && rightIdx < right.size) {
        if (left[leftIdx] <= right[rightIdx]) {
            mergedList.add(left[leftIdx])
            leftIdx++
        } else {
            mergedList.add(right[rightIdx])
            rightIdx++
        }
    }

    while (leftIdx < left.size) {
        mergedList.add(left[leftIdx])
        leftIdx++
    }

    while (rightIdx < right.size) {
        mergedList.add(right[rightIdx])
        rightIdx++
    }
    return mergedList
}

fun main() {
    val list = mutableListOf<Int>()
    for (i in 0 until 10) {
        val number = (0..30).random()
        list.add(number)
    }
    print(mergeSort(list))
}
