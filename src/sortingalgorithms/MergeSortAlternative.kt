package sortingalgorithms

fun mergeSort(array: MutableList<Int>): List<Int> {
    // Write your code here.
    if (array.size <= 1) return array
    val auxArray = array.toMutableList()
    mergeSortHelper(array, 0, array.size - 1, auxArray)
    return array
}

fun mergeSortHelper(mainArray: MutableList<Int>, startIdx: Int, endIdx: Int, auxArray: MutableList<Int>) {
    if (startIdx == endIdx) return
    val middleIdx = (startIdx + endIdx) / 2
    mergeSortHelper(auxArray, startIdx, middleIdx, mainArray)
    mergeSortHelper(auxArray, middleIdx + 1, endIdx, mainArray)
    doMerge(mainArray, startIdx, middleIdx, endIdx, auxArray)
}

fun doMerge(mainArray: MutableList<Int>, startIdx: Int, middleIdx: Int, endIdx: Int, auxArray: List<Int>) {
    var k = startIdx
    var i = startIdx
    var j = middleIdx + 1
    while (i <= middleIdx && j <= endIdx) {
        if (auxArray[i] <= auxArray[j]) {
            mainArray[k++] = auxArray[i++]
        } else {
            mainArray[k++] = auxArray[j++]
        }
    }
    while (i <= middleIdx) {
        mainArray[k++] = auxArray[i++]
    }
    while (j <= endIdx) {
        mainArray[k++] = auxArray[j++]
    }
}

fun main() {
    val list = mutableListOf<Int>()
    for (i in 0 until 10) {
        val number = (0..30).random()
        list.add(number)
    }
    print(mergeSort(list))
}
