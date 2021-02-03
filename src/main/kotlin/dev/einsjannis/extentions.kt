package dev.einsjannis

fun <T> MutableList<T>.move(from: Int, to: Int) {
    val value = get(from)
    removeAt(from)
    add(to, value)
}

operator fun MatchGroupCollection?.component1(): String? = this?.get(0)?.value
operator fun MatchGroupCollection?.component2(): String? = this?.get(1)?.value
operator fun MatchGroupCollection?.component3(): String? = this?.get(2)?.value
operator fun MatchGroupCollection?.component4(): String? = this?.get(3)?.value
operator fun MatchGroupCollection?.component5(): String? = this?.get(4)?.value
operator fun MatchGroupCollection?.component6(): String? = this?.get(5)?.value
operator fun MatchGroupCollection?.component7(): String? = this?.get(6)?.value
operator fun MatchGroupCollection?.component8(): String? = this?.get(7)?.value
operator fun MatchGroupCollection?.component9(): String? = this?.get(8)?.value
operator fun MatchGroupCollection?.component10(): String? = this?.get(9)?.value
operator fun MatchGroupCollection?.component11(): String? = this?.get(10)?.value
operator fun MatchGroupCollection?.component12(): String? = this?.get(11)?.value
operator fun MatchGroupCollection?.component13(): String? = this?.get(12)?.value
operator fun MatchGroupCollection?.component14(): String? = this?.get(13)?.value
operator fun MatchGroupCollection?.component15(): String? = this?.get(14)?.value
operator fun MatchGroupCollection?.component16(): String? = this?.get(15)?.value
operator fun MatchGroupCollection?.component17(): String? = this?.get(16)?.value
