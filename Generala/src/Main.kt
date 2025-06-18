//
//  GitHub
//  Ejercicio realizado por Sofia Sanabria
//
//  Jugadas Generala
//

import kotlin.random.Random

fun jugadasGenerala() : String {

    val dados = mutableListOf<Int>()

    // Agregar 5 valores al array de dados
    for (i in 1..5) {
        dados.add(Random.nextInt(1, 7))
    }

    // Contar cuantas veces aparece cada numero
    val conteo = mutableMapOf<Int, Int>()
    for (dado in dados) {
        conteo[dado] = conteo.getOrDefault(dado, 0) + 1
    }

    val repeticiones = mutableListOf<Int>()

    // Contar las repeticiones
    for (i in 1..6) {
        if ((conteo[i] ?: 0) > 1) {
            repeticiones.add(conteo[i] ?: 0)
        }
    }
    // Ordenar dados
    val ordenado = dados.sorted()

    // Secuencia de posibles escaleras
    val secA = arrayOf(1, 2, 3, 4, 5)
    val secB = arrayOf(2, 3, 4, 5, 6)
    val secC = arrayOf(3, 4, 5, 6, 1)

    // Convertir un arreglo a string y separar por coma
    val resultado = ordenado.joinToString(", ")

    val jugada = when {
        repeticiones == listOf(5) -> "GENERALA"
        repeticiones == listOf(4) -> "POKER"
        repeticiones == listOf(2, 3) -> "FULL"
        // Convertir los arrays a listas para comparar
        ordenado.toList() == secA.toList() ||
        ordenado.toList() == secB.toList() ||
        ordenado.toSet() == secC.toSet() -> "ESCALERA"
        else -> "NADA"
    }

    return "Dados: $resultado -> Jugada: $jugada"
}

fun main() {
    val jugadas = jugadasGenerala()
    println(jugadas)
}