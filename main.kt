fun main(args: Array<String>) {
    var mentors: List<String> = listOf("079399", "096964", "063859", "083257", "096596", "116819", "109491", "062694")
    var descSortedNtSumMap: Map<String, Int> = getDescSortedNtSumMap(mentors)
    println("Sort mentors by NT sum = $descSortedNtSumMap")
    var groups: MutableList<String> = getShuffledGroups(mentors.size)
    println("Generate the shuffled groups = $groups")
    var mentorsGroup: MutableMap<String, String> = getMentorGroupMap(descSortedNtSumMap, groups)
    println("Final groups = $mentorsGroup")
}

fun getMentorGroupMap(sortedNts: Map<String, Int>, shuffledGroup: MutableList<String>): MutableMap<String, String> {
    var mentorsGroup: MutableMap<String, String> = mutableMapOf()
    var indexI:Int = 0
    sortedNts.forEach() { it->
        mentorsGroup.putIfAbsent(it.key, shuffledGroup[indexI++])
    }
    return mentorsGroup
}

fun getDescSortedNtSumMap(nts: List<String>): Map<String, Int> {
    var mentorsNtSumMap: MutableMap<String, Int> = mutableMapOf()
    nts.forEach { it ->
        var charToIntSum: Int = 0
        it.toList().forEach { charIt ->
            charToIntSum += charIt.toString().toInt()
        }
        mentorsNtSumMap.putIfAbsent(it, charToIntSum)
    }
    return mentorsNtSumMap.toList().sortedByDescending { (_, value) -> value }.toMap()
}

fun getShuffledGroups(groupsCnt: Int): MutableList<String> {
    var groups: MutableList<String> = mutableListOf()
    for (i in 1..groupsCnt) {
        groups.add((i+65-1).toChar().toString())
    }
    groups.shuffle()
    return groups
}

