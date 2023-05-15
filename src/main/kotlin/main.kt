import kotlin.math.absoluteValue

const val MINUTE = 60
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

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
        in 61..HOUR -> "${time / 60} ${minutes(time)} назад"
        in HOUR + 1..DAY -> "${time / HOUR} ${hours(time)} назад"
        in DAY + 1..DAY * 2 -> "вчера"
        in DAY * 2 + 1..DAY * 3 -> "позавчера"
        else -> "давно"
    }
}

fun minutes(time: Int): String {
    return when {
        (time / MINUTE) % 10 == 1 && (time / MINUTE) != 11 -> "минуту"
        (time / MINUTE) % 10 in 2..4 && time / MINUTE !in 12..14 -> "минуты"
        else -> "минут"
    }
}

fun hours(time: Int): String {
    return when {
        (time / HOUR) % 10 == 1 && (time / HOUR) != 11 -> "час"
        (time / HOUR) % 10 in 2..4 && time / HOUR !in 12..14 -> "часа"
        else -> "часов"
    }
}
