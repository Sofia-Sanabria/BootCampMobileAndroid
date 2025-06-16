fun main () {
    //Crear una lista de especias
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    // Filtrar todos los curries y ordenarlos por la longitud de la cadena
    val curries = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println(curries)

    // Filtrar las especias que comienzan con 'c' y terminan con 'e'
    val filtered1 = spices.filter { it.startsWith("c") && it.endsWith("e") }
    println(filtered1) // Usando filter con una condición combinada

    val filtered2 = spices.filter { it.startsWith("c") }.filter { it.endsWith("e") }
    println(filtered2) // Dividiendo la condición en pasos

    // Tomar los primeros 3 elementos y devolver los que comienzan con 'c'
    val firstThreeC = spices.take(3).filter { it.startsWith("c") }
    println(firstThreeC)
}