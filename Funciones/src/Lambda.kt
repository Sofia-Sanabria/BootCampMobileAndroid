fun main () {
    // Devuelve un número aleatorio entre 1 y 12.
    val rollDice = { (1..12).random() }

    //  Recibe un argumento: el número de caras del dado.
    val rollDice2 = { sides: Int ->
        (1..sides).random()
    }

    // Devuelve 0 si el número de lados es 0.
    val rollDice3 = { sides: Int ->
        if (sides == 0) 0 else (1..sides).random()
    }

    // Usando la notación de tipo de función.
    val rollDice4: (Int) ->
    Int = { sides -> if (sides == 0) 0 else (1..sides).random()
    }

    println("Tirando un dado de 12 caras: ${rollDice()}")
    println("Tirando un dado de 6 caras: ${rollDice2(6)}")
    println("Tirando un dado de 0 caras: ${rollDice3(0)}")
    println("Tirando un dado de 20 caras: ${rollDice4(20)}")
}