import java.util.Calendar

fun main() {
    println("Hello and welcome!")
    diaSemana()
}

fun diaSemana() {
    println("¿Qué día es hoy?")
    val dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

    println ( when (dia) {
        1 -> "Domingo"
        2 -> "Lunes"
        3 -> "Martes"
        4 -> "Miércoles"
        5 -> "Jueves"
        6 -> "Viernes"
        7 -> "Sábado"
        else -> "Día inválido"
    })
}
