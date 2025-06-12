
//
// Ejercicio realizado por Sofia Sanabria
// Logica de Juego de Hakembo
//

fun main () {

    val opciones = listOf("piedra", "papel", "tijera")

    println("Bienvenido al juego HA-KE-MBO")

    var jugarDeNuevo = true

    while(jugarDeNuevo) {
        println("Elige: piedra, papel o tijera")
        val jugador = readLine()

        if(jugador !in opciones) {
            println("Eleccion Invalida. Intente otra vez")
            continue
        }

        val computadora = opciones.random()
        println("La computadora eligio $computadora")

        if (jugador == computadora)  {
            println("Empate!!")
        } else if (jugador == "piedra" && computadora == "tijera" ||
                    jugador == "tijera" && computadora == "papel" ||
                    jugador == "papel" && computadora == "piedra") {
            println("Ganaste!!")
        } else {
            println("Perdiste!!")
        }

        println("Quieres jugar de nuevo? (si/no)")
        val respuesta = readLine()?.lowercase()
        jugarDeNuevo = respuesta == "si"
    }

    println("Gracias por jugar!")
}
