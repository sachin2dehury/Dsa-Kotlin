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
        var start = 0
        var end = items.lastIndex
        var floor = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                floor = item
                break
            } else if (items[mid] < item) {
                start = mid + 1
                floor = items[mid]
            } else {
                end = mid - 1
            }
        }

        var ceil = -1
        start = 0
        end = items.lastIndex
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                ceil = item
                break
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
                ceil = items[mid]
            }
        }

        val result = if (ceil - item < item - floor) {
            ceil
        } else {
            floor
        }

        println(result)
        return result
    }

    override fun nextAlphabetInList(items: List<Char>, item: Char): Char {
        var start = 0
        var end = items.lastIndex
        var result = '#'
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == item) {
                if (mid != end) {
                    result = items[mid + 1]
                }
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

    override fun numberOfRotation(items: List<Int>): Int {
        var start = 0
        var end = items.lastIndex

        var result = -1

        if (items.first() < items.last()) {
            result = 0
        }

        while (result == -1) {
            val mid = end - (end - start) / 2
            val prevItem = (items.size + mid - 1) % items.size
            val nextItem = (mid + 1) % items.size
            if (items[mid] < items[prevItem] && items[mid] < items[nextItem]) {
                result = mid
                break
            } else if (items[mid] < items[start]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        println(result)
        return result
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
