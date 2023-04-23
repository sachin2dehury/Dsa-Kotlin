package binarysearch

class BinarySearchSolutions : BinarySearchProblems {
    override fun binarySearch(items: List<Int>, item: Int): Int {
        var start = 0
        var end = items.lastIndex
        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                result = mid
                break
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        println(result)
        return result
    }

    override fun reverseBinarySearch(items: List<Int>, item: Int): Int {
        var start = 0
        var end = items.lastIndex
        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                result = mid
                break
            } else if (items[mid] < item) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        println(result)
        return result
    }

    override fun firstOccurrenceOfElement(items: List<Int>, item: Int): Int {
        var start = 0
        var end = items.lastIndex
        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                result = mid
                end = mid - 1
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        println(result)
        return result
    }

    override fun lastOccurrenceOfElement(items: List<Int>, item: Int): Int {
        var start = 0;
        var end = items.lastIndex
        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                result = mid
                start = mid + 1
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        println(result)
        return result
    }

    override fun countOfAnElement(items: List<Int>, item: Int): Int {
        var start = 0
        var end = items.lastIndex
        var firstOccurrence = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                firstOccurrence = mid
                end = mid - 1
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        var lastOccurrence = -1
        start = 0
        end = items.lastIndex
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                lastOccurrence = mid
                start = mid + 1
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        val result = lastOccurrence - firstOccurrence + 1
        println(result)
        return result
    }

    override fun floorOfAnElement(items: List<Int>, item: Int): Int {
        var start = 0
        var end = items.lastIndex
        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                result = item
                break
            } else if (items[mid] < item) {
                start = mid + 1
                result = items[mid]
            } else {
                end = mid - 1
            }
        }

        println(result)
        return result
    }

    override fun ceilOfAnElement(items: List<Int>, item: Int): Int {
        var start = 0
        var end = items.lastIndex
        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                result = item
                break
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
                result = items[mid]
            }
        }

        println(result)
        return result
    }

    override fun minimumDifferenceElement(items: List<Int>, item: Int): Int {
        TODO("Not yet implemented")
    }

    override fun nextAlphabetInList(items: List<Char>, item: Char): Char {
        TODO("Not yet implemented")
    }

    override fun numberOfRotation(items: List<Int>): Int {
        TODO("Not yet implemented")
    }

    override fun binarySearchInRotatedList(items: List<Int>, item: Int): Int {
        TODO("Not yet implemented")
    }

    override fun peakElement(items: List<Int>): Int {
        TODO("Not yet implemented")
    }

    override fun firstOccurrenceOfOne(items: List<Int>): Int {
        TODO("Not yet implemented")
    }

    override fun maximumElementInBitonicList(items: List<Int>): Int {
        TODO("Not yet implemented")
    }

    override fun binarySearchInBitonicList(items: List<Int>, item: Int): Int {
        TODO("Not yet implemented")
    }

    override fun binarySearchInInfiniteList(items: List<Int>, item: Int): Int {
        TODO("Not yet implemented")
    }

    override fun binarySearchInNearlySortedList(items: List<Int>, item: Int): Int {
        TODO("Not yet implemented")
    }

    override fun binarySearchInUnknownOrder(items: List<Int>, item: Int): Int {
        TODO("Not yet implemented")
    }

    override fun binarySearchInMatrix(items: List<List<Int>>, item: Int): Pair<Int, Int> {
        TODO("Not yet implemented")
    }
}
