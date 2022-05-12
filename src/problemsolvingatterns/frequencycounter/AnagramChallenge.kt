package problemsolvingatterns.frequencycounter

/**
 * Given two strings, write a function to determine if the second string is an anagram of the first string.
 *
 * */
fun isAnagram(firstWord: String, secondWord: String): Boolean{
    if (firstWord.length != secondWord.length) {
        return false
    }
    val firstStore = mutableMapOf<Char, Int>()
    val secondStore = mutableMapOf<Char, Int>()

    firstWord.toLowerCase().forEach {
        firstStore[it] = firstStore[it]?:0 + 1
    }
    secondWord.toLowerCase().forEach {
        secondStore[it] = secondStore[it]?:0 + 1
    }

    firstStore.forEach { (key, _) ->
        if (!secondStore.containsKey(key)) return false
        if (firstStore[key] != secondStore[key]) return false
    }
    return true
}

fun isAnagramShorter(firstWord: String, secondWord: String): Boolean {

    val letterFrequency = hashMapOf<Char, Int>()

    firstWord.toLowerCase().forEach { letter ->
        letterFrequency[letter] = letterFrequency[letter]?:0 + 1
    }

    secondWord.toLowerCase().forEachIndexed { i, _ ->
        val letter = secondWord[i]
        if (!letterFrequency.containsKey(letter)) {
            return false
        } else {
            letterFrequency[letter] = letterFrequency[letter]?:0 - 1
        }
    }
    return true
}

fun main() {
    val firstArray = arrayListOf(1, 3, 7)
    val secondArray = arrayListOf(1, 49, 9)

    val result = same(firstArray, secondArray)
    println(result)

    val firstWord = "Hammer"
    val secondWord = "rema"

    println(isAnagramShorter(firstWord, secondWord))

    println(isAnagram("anagram", "nagaram"))
}