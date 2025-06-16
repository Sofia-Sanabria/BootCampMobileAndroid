import kotlin.io.println

fun main(args: Array<String>) {
    var count = 0
    // repeat solo admite repeticiones fijas
    while (count < 10) {
        val fortune = getFortune(getBirthday())
        println("Tu fortuna es: $fortune")
        if (fortune.contains("Tómatelo con calma y disfruta de la vida.") ) break
        count++
    }
}

fun getBirthday(): Int {
    print("Introduce tu fecha de cumpleaños: ")
    return readLine()?.toIntOrNull() ?: 1 // Leer entrada y lo convierte en Int
}

fun getFortune(birthday: Int) : String {

    val fortunes = listOf(
        "¡Tendrás un gran día!",
        "Hoy todo te saldrá bien.",
        "Disfruta un maravilloso día de éxito.",
        "Sé humilde y todo saldrá bien.",
        "Hoy es un buen día para ejercitar la paciencia.",
        "Tómatelo con calma y disfruta de la vida.",
        "Valora a tus amigos, porque son tu mayor fortuna."
    )

    return when {
        birthday == 28 || birthday == 31 -> "Recibirás una gran sorpresa muy pronto."
        birthday in 1..7 -> "Esta semana trae nuevas oportunidades."
        else -> fortunes[birthday % fortunes.size] //  calcular el indice con el operador %
    }
}