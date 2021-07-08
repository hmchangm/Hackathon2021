fun main() {
    val mentors = listOf("079399", "096964", "063859", "083257", "096596", "116819", "109491", "062694")
    val groups = getShuffledGroups(mentors.size)
    val descSortedNtSumMap = toDescSortedNtSumMap(mentors)
    println("Sort mentors by NT sum = $descSortedNtSumMap")
    println("Generate the shuffled groups = $groups")
    val mentorsGroup = assignMentorGroupMap(descSortedNtSumMap, groups)
    println("Final groups = $mentorsGroup")
}

fun assignMentorGroupMap(sortedNts: Map<String, Int>, shuffledGroup: MutableList<String>): MutableMap<String, String> {
    var mentorsGroup = mutableMapOf<String, String>()
    for ((i, v) in sortedNts.entries.withIndex()) {
        mentorsGroup[v.key]=shuffledGroup[i]
    }
    return mentorsGroup
}

fun toDescSortedNtSumMap(nts: List<String>): Map<String, Int> {
    var mentorsNtSumMap = mutableMapOf<String, Int>()
    nts.forEach {
        var charToIntSum: Int = 0
        it.forEach { char ->
            charToIntSum += char.toInt()
        }
        mentorsNtSumMap[it] = charToIntSum
    }
    return mentorsNtSumMap.toList().sortedByDescending { (_, value) -> value }.toMap()
}

fun getShuffledGroups(groupsCnt: Int): MutableList<String> {
    var groups = mutableListOf<String>()
    for (i in 1..groupsCnt) {
        groups.add((i + 65 - 1).toChar().toString())
    }
    groups.shuffle()
    return groups
}