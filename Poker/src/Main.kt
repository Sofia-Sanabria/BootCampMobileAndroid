//
//  GitHub
//  Ejercicio realizado por Sofia Sanabria
//
//  Jugadas de Poker
//

class Carta(representa: String) {
    val valor: String = representa.first().toString() // Primer caracter: valor
    val palo: String = representa.last().toString()   // Segundo caracter: palo

    // Convierte el valor textual a su representación numérica
    fun valorNumerico(): Int = when (valor) {
        "A" -> 14
        "K" -> 13
        "Q" -> 12
        "J" -> 11
        "T" -> 10
        else -> valor.toIntOrNull() ?: 0
    }
}

// Interfaz que define una jugada de Poker
interface JugadaPoker {
    val tipo: String
    val ranking: Int
}

// Clase sellada que representa las posibles jugadas
sealed class Jugada(override val tipo: String, override val ranking: Int) : JugadaPoker {
    object EscaleraColor : Jugada("Escalera de Color", 9)
    object Poker : Jugada("Poker", 8)
    object Full : Jugada("Full", 7)
    object Color : Jugada("Color", 6)
    object Escalera : Jugada("Escalera", 5)
    object Trio : Jugada("Trio", 4)
    object DoblePar : Jugada("Doble par", 3)
    object Par : Jugada("Par", 2)
    object CartaAlta : Jugada("Carta alta", 1)
}

// Representa el resultado de una mano
data class Resultado(
    val jugador: String,
    val jugada: JugadaPoker,
    val valores: List<Int>
)

// Analiza una mano y devuelve su jugada
fun analizarMano(jugador: String, cartas: List<Carta>): Resultado {
    val conteoValores = mutableMapOf<Int, Int>()
    val conteoPalos = mutableMapOf<String, Int>()
    val valores = cartas.map { carta ->
        val num = carta.valorNumerico()
        // Cuantas veces aparece cada valor de carta
        // Si no existe valor, asumir que es 0(cero)
        conteoValores[num] = conteoValores.getOrDefault(num, 0) + 1
        conteoPalos[carta.palo] = conteoPalos.getOrDefault(carta.palo, 0) + 1
        num
    }.sortedDescending() // ordena valores de mayor a menor

    // Es Color cuando hay 5 cartas con el mismo palo
    val esColor = conteoPalos.values.any { it == 5 }
    // Es Escalera cuando hay 5 cartas con valores concecutivos
    val esEscalera = (valores.first() - valores.last() == 4) && valores.toSet().size == 5
    // 14 en vez de 1 es escalera tambien
    val escaleraBaja = valores.toSet() == setOf(14, 2, 3, 4, 5)

    val jugada = when {
        (esEscalera || escaleraBaja) && esColor -> Jugada.EscaleraColor
        4 in conteoValores.values -> Jugada.Poker
        3 in conteoValores.values && 2 in conteoValores.values -> Jugada.Full
        esColor -> Jugada.Color
        esEscalera || escaleraBaja -> Jugada.Escalera
        3 in conteoValores.values -> Jugada.Trio
        conteoValores.values.count { it == 2 } == 2 -> Jugada.DoblePar
        2 in conteoValores.values -> Jugada.Par
        else -> Jugada.CartaAlta
    }

    return Resultado(jugador, jugada, valores)
}

// Compara dos resultados y determina el ganador
fun determinarGanador(j1: Resultado, j2: Resultado) {
    println("${j1.jugador}: ${j1.jugada.tipo}")
    println("${j2.jugador}: ${j2.jugada.tipo}")

    if (j1.jugada.ranking > j2.jugada.ranking) {
        println("Gana ${j1.jugador} con ${j1.jugada.tipo}!")
    } else if (j2.jugada.ranking > j1.jugada.ranking) {
        println("Gana ${j2.jugador} con ${j2.jugada.tipo}!")
    } else {
        // Comparar por valores en caso de empate de tipo
        val comparacion = j1.valores.zip(j2.valores)
        for ((v1, v2) in comparacion) {
            if (v1 > v2) {
                println("Gana ${j1.jugador} por tener cartas más altas!")
                return
            } else if (v2 > v1) {
                println("Gana ${j2.jugador} por tener cartas más altas!")
                return
            }
        }
        println("Empate!")
    }
}

// -------- Ejemplo de uso ---------
fun main() {

    // Jugada Poker
    val cartasJugador1 = listOf(
        Carta("KS"), Carta("KH"), Carta("KC"), Carta("KD"), Carta("5H")
    )
    // Jugada Escalera de color baja (A, 2, 3, 4, 5)
    val cartasJugador2 = listOf(
        Carta("AS"), Carta("2S"), Carta("3S"), Carta("4S"), Carta("5S")
    )

    val resultado1 = analizarMano("Sofi", cartasJugador1)
    val resultado2 = analizarMano("Xime", cartasJugador2)

    determinarGanador(resultado1, resultado2)
}
