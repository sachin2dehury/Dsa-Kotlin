package binarysearch

import kotlin.math.min

class BinarySearchSolutions : BinarySearchProblems {
    override fun binarySearch(items: List<Int>, item: Int) {
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
    }

    override fun reverseBinarySearch(items: List<Int>, item: Int) {
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
    }

    override fun firstOccurrenceOfElement(items: List<Int>, item: Int) {
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
    }

    override fun lastOccurrenceOfElement(items: List<Int>, item: Int) {
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
    }

    override fun countOfAnElement(items: List<Int>, item: Int) {
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
    }

    override fun floorOfAnElement(items: List<Int>, item: Int) {
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
    }

    override fun ceilOfAnElement(items: List<Int>, item: Int) {
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
    }

    override fun minimumDifferenceElement(items: List<Int>, item: Int) {
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
    }

    override fun nextAlphabetInList(items: List<Char>, item: Char) {
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
    }

    override fun numberOfRotation(items: List<Int>) {
        var start = 0
        var end = items.lastIndex

        var result = -1

        if (items.first() < items.last()) {
            result = 0
        }

        while (result == -1) {
            val mid = end - (end - start) / 2
            val prevIndex = (items.size + mid - 1) % items.size
            val nextIndex = (mid + 1) % items.size
            if (items[mid] < items[prevIndex] && items[mid] < items[nextIndex]) {
                result = mid
                break
            } else if (items[mid] < items[start]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        println(result)
    }

    override fun binarySearchInRotatedList(items: List<Int>, item: Int) {
        var start = 0
        var end = items.lastIndex

        var rotation = -1
        if (items.first() < items.last()) {
            rotation = 0
        }

        while (rotation == -1) {
            val mid = end - (end - start) / 2
            val prevIndex = (items.size + mid - 1) % items.size
            val nextIndex = (mid + 1) % items.size
            if (items[mid] < items[prevIndex] && items[mid] < items[nextIndex]) {
                rotation = mid
            } else if (items[mid] < items[start]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        var result = -1

        if (items.last() < item) {
            start = 0
            end = rotation - 1
        } else {
            start = rotation
            end = items.lastIndex
        }

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
    }

    override fun peakElement(items: List<Int>) {
        var start = 0
        var end = 0
        var result = -1

        while (end >= start) {
            val mid = end - (end - start) / 2
            val prevIndex = (items.size + mid - 1) % items.size
            val nextIndex = (mid + 1) % items.size
            if (items[mid] > items[prevIndex] && items[mid] > items[nextIndex]) {
                result = items[mid]
                break
            } else if (items[mid] > items[prevIndex] && items[mid] < items[nextIndex]) {
                start = nextIndex
            } else {
                end = prevIndex
            }
        }

        println(result)
    }

    override fun firstOccurrenceOfOne(items: List<Int>) {
        var start = 0
        var end = 1
        while (end <= items.lastIndex && items[end] < 1) {
            start = end
            end *= 2
        }

        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            if (items[mid] == 1) {
                result = mid
                end = mid - 1
            } else if (items[mid] < 1) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        println(result)
    }

    override fun maximumElementInBitonicList(items: List<Int>) {
        var start = 0
        var end = items.lastIndex

        var result = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            val prevIndex = (items.size + mid - 1) % items.size
            val nextIndex = (mid + 1) % items.size
            if (items[mid] > items[prevIndex] && items[mid] > items[nextIndex]) {
                result = items[mid]
                break
            } else if (items[mid] < items[start]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        println(result)
    }

    override fun binarySearchInBitonicList(items: List<Int>, item: Int) {
        var start = 0
        var end = items.lastIndex

        var peakIndex = -1
        while (end >= start) {
            val mid = end - (end - start) / 2
            val prevIndex = (items.size + mid - 1) % items.size
            val nextIndex = (mid + 1) % items.size
            if (items[mid] > items[prevIndex] && items[mid] > items[nextIndex]) {
                peakIndex = mid
                break
            } else if (items[mid] < items[start]) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        start = 0
        end = peakIndex
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

        start = peakIndex + 1
        end = items.lastIndex

        while (end >= start && result == -1) {
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
    }

    override fun binarySearchInInfiniteList(items: List<Int>, item: Int) {
        var start = 0
        var end = 1
        while (end <= items.lastIndex && items[end] < item) {
            start = end
            end *= 2
        }

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
    }

    override fun binarySearchInNearlySortedList(items: List<Int>, item: Int) {
        var start = 0
        var end = items.lastIndex
        var result = -1

        while (end >= start) {
            val mid = end - (end - start) / 2
            val prevIndex = (items.size + mid - 1) % items.size
            val nextIndex = (mid + 1) % items.size
            if (items[mid] == item) {
                result = mid
                break
            } else if (items[prevIndex] == item) {
                result = prevIndex
                break
            } else if (items[nextIndex] == item) {
                result = nextIndex
                break
            } else if (items[mid] < item) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        println(result)
    }

    override fun binarySearchInUnknownOrder(items: List<Int>, item: Int) {
        return if (items.first() < items.last()) {
            binarySearch(items, item)
        } else {
            reverseBinarySearch(items, item)
        }
    }

    override fun binarySearchInMatrix(items: List<List<Int>>, item: Int) {
        var i = 0
        var j = items.first().lastIndex

        var result = -1 to -1
        while (i <= items.lastIndex && j >= 0) {
            if (items[i][j] == item) {
                result = i to j
                break
            } else if (items[i][j] < item) {
                i++
            } else {
                j--
            }
        }

        println(result)
    }

    override fun allocateNumberOfPages(items: List<Int>, k: Int) {
        if (items.size < k) {
            println("Not Possible")
            return
        }

        var end = items.sum()
        var start = items.last()
        var result = Int.MAX_VALUE

        while (end >= start) {
            val mid = end - (end - start) / 2
            var sum = 0
            var count = 1

            for (i in items.indices) {
                if (sum > mid) {
                    sum = items[i]
                    count++
                } else {
                    sum += items[i]
                }
            }

            if (count > k) {
                start = mid + 1
            } else {
                end = mid - 1
                result = min(mid, result)
            }
        }

        println(result)
    }
}
