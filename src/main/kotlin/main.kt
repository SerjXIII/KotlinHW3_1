import kotlin.math.absoluteValue

const val minute = 60
const val hour = 60 * minute
const val day = 24 * hour

fun main() {

    while (true) {
        print("Введите количество секунд: ")
        val time: Int = readln().toInt()
        println("\nбыл(а) ${agoToText(time.absoluteValue)}\n")
    }
}

fun agoToText(time: Int): String {

    return when (time) {
        in 0..60 -> "только что"
        in 61..hour -> "${time / 60} ${minutes(time)} назад"
        in hour + 1..day -> "${time / hour} ${hours(time)} назад"
        in day + 1..day * 2 -> "вчера"
        in day * 2 + 1..day * 3 -> "позавчера"
        else -> "давно"
    }
}

fun minutes(time: Int): String {
    return when {
        (time / minute) % 10 == 1 && (time / minute) != 11 -> "минуту"
        (time / minute) % 10 in 2..4 && time / minute !in 12..14 -> "минуты"
        else -> "минут"
    }
}

fun hours(time: Int): String {
    return when {
        (time / hour) % 10 == 1 && (time / hour) != 11 -> "час"
        (time / hour) % 10 in 2..4 && time / hour !in 12..14 -> "часа"
        else -> "часов"
    }
}
