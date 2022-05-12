package problemsolvingatterns.multiplepointers

fun countUniqueValues(arr: MutableList<Int>): Int {
    var i = 0
    var j = 1
    while (j < arr.size) {
        if (arr[i] != arr[j]) {
            i++
            arr[i] = arr[j]
        }
        j++
    }
    return i + 1
}

fun main() {
    val result = countUniqueValues(mutableListOf(1,1,1,2,3,4,5,5,6,6,6,6,7,8))
    println(result)
}