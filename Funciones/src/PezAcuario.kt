fun main () {
    println("Caso 1: " + fitMoreFish(10, listOf(3, 3, 3)))
    println("Caso 2: " + fitMoreFish(8, listOf(2, 2, 2), fishSize = 2))
    println("Caso 3: " + fitMoreFish(9, listOf(), fishSize = 3))
    println("Caso 4: " + fitMoreFish(10, listOf(2, 2, 2), hasDecorations = false))
    println("Caso 5: " + fitMoreFish(20, listOf(2, 2, 2, 2, 2, 2)))
}

fun fitMoreFish(
    tankSize: Int,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean{
    // Si tiene decoracion, solo puedes usar el 80% de su capacidad
    val capacity = if (hasDecorations) tankSize * 0.8 else tankSize.toDouble()
    val currentFish = currentFish.sum() // suma las pulgadas de los peces
    return (currentFish + fishSize) <= capacity // Comparacion para saber si entra el nuevo pez

}

