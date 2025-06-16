class Reloj {

    private var hora: Int = 0
    private var minutos: Int = 0
    private var segundos: Int = 0

    // Constructor principal (por defecto a las 12:00:00)
    constructor() {
        hora = 12
        minutos = 0
        segundos = 0
    }

    // Constructor con hora, minutos y segundos
    constructor(hora: Int, minutos: Int, segundos: Int) {
        this.hora = hora % 24
        this.minutos = minutos % 60
        this.segundos = segundos % 60
    }

    // Constructor con segundos desde medianoche
    constructor(segundosDesdeMedianoche: Int) {
        setReloj(segundosDesdeMedianoche)
    }

    // Getters
    fun getHoras(): Int = hora
    fun getMinutos(): Int = minutos
    fun getSegundos(): Int = segundos

    // Setters
    fun setHoras(hora: Int) {
        this.hora = hora % 24
    }

    fun setMinutos(minutos: Int) {
        this.minutos = minutos % 60
    }

    fun setSegundos(segundos: Int) {
        this.segundos = segundos % 60
    }

    // Método para establecer hora desde segundos totales
    private fun setReloj(segundosTotales: Int) {
        val seg = segundosTotales % 86400
        hora = (seg / 3600) % 24
        minutos = (seg % 3600) / 60
        segundos = seg % 60
    }

    // Incrementar en un segundo
    fun tick() {
        segundos += 1
        if (segundos == 60) {
            segundos = 0
            minutos += 1
            if (minutos == 60) {
                minutos = 0
                hora += 1
                if (hora == 24) {
                    hora = 0
                }
            }
        }
    }

    // Decrementar en un segundo
    fun tickDecrement() {
        segundos -= 1
        if (segundos < 0) {
            segundos = 59
            minutos -= 1
            if (minutos < 0) {
                minutos = 59
                hora -= 1
                if (hora < 0) {
                    hora = 23
                }
            }
        }
    }

    // Suma de otro reloj
    fun addReloj(otro: Reloj) {
        val segActual = hora * 3600 + minutos * 60 + segundos
        val segOtro = otro.hora * 3600 + otro.minutos * 60 + otro.segundos
        val suma = (segActual + segOtro) % (24 * 3600)
        setReloj(suma)
    }

    // Resta de otro reloj
    fun restaReloj(otro: Reloj) {
        val segActual = hora * 3600 + minutos * 60 + segundos
        val segOtro = otro.hora * 3600 + otro.minutos * 60 + otro.segundos
        var diferencia = segActual - segOtro
        if (diferencia < 0) {
            diferencia += 24 * 3600
        }
        setReloj(diferencia)
    }

    // Mostrar hora en formato "[HH:MM:SS]"
    fun toStringHora(): String {
        return if (hora in 0..23 && minutos in 0..59 && segundos in 0..59) {
            "[%02d:%02d:%02d]".format(hora, minutos, segundos)
        } else {
            "Valores inválidos"
        }
    }
}

fun main() {

    println("¡Hola! Bienvenidos al Reloj.")

    println("Ingrese los segundos desde la media noche")

    // Lee entrada del usuario, convierte a entero
    val segundos = readLine()?.toIntOrNull()

    // Valida rango de segundo, si algo no se cumple, retorna
    if (segundos != null && segundos in 0..86400) {
        println("Entrada valida: $segundos segundos.")
    } else {
        println("Entrada invalida.")
        return
    }

    // Crear la instancia del primer reloj
    val miReloj = Reloj( segundos)
    println("Hora inicial: ${miReloj.toStringHora()}")

    println("Horas: ${miReloj.getHoras()}")
    println("Minutos: ${miReloj.getMinutos()}")
    println("Segundos: ${miReloj.getSegundos()}")

    // Imprime 10 veces la hora al incrementar los segundos
    var i = 0
    println("-- Hora incrementando tick --")
    while (i in 0..10) {
        miReloj.tick()
        println("Hora tick $i: ${miReloj.toStringHora()}")
        i = i + 1
    }

    // Imprime 10 veces la hora al decrementar los segundos
    var j = 0
    println("-- Hora decrementando tick --")
    while (j in 0..10) {
        miReloj.tickDecrement()
        println("Hora tick $j: ${miReloj.toStringHora()}")
        j = j + 1
    }

    // Crear otra instancia de Reloj para agregarle tiempo
    val reloj1 = Reloj(12, 45, 5)

    miReloj.addReloj(reloj1)

    println("La hora actual agregando ${reloj1.toStringHora()} es ${miReloj.toStringHora()}")

    // Crear otra instancia de Reloj para restarle tiempo
    val reloj2 = Reloj(4, 16,11)

    miReloj.restaReloj(reloj2)

    println("La hora actual restando ${reloj2.toStringHora()} es ${miReloj.toStringHora()} ")

}

// DemoReloj.main()

