class Coche(
    color: String,
    marca: String,
    modelo: String,
    nCaballos: Int,
    nPuertas: Int,
    matricula: String
) {

    var color: String = color
        set(value) {
            require(value.isNotBlank()) { "El color no puede estar vacío" }
            field = value
        }

    var nCaballos: Int = nCaballos
        set(value) {
            require(value in 70..700) { "El número de caballos debe estar entre 70 y 700" }
            field = value
        }

    var nPuertas: Int = nPuertas
        set(value) {
            require(value in 3..5) { "Número de puertas debe estar entre 3 y 5" }
            field = value
        }

    var matricula: String = matricula
        set(value) {
            require(value.length == 7) { "La matrícula debe tener 7 caracteres" }
            field = value
        }

    val marca: String = marca
    val modelo: String = modelo

    init {
        require(marca.isNotBlank()) { "La marca no puede estar vacía" }
        require(modelo.isNotBlank()) { "El modelo no puede estar vacío" }
    }

    override fun toString(): String {
        return "Coche(color='$color', marca='$marca', modelo='$modelo', nCaballos=$nCaballos, nPuertas=$nPuertas, matricula='$matricula')"
    }
}

fun main() {

    println("<<< Coches válidos >>>")
    val coche1 = Coche("Rojo", "Toyota", "Corolla", 120, 4, "ABC1234")
    val coche2 = Coche("Azul", "Honda", "Civic", 150, 5, "XYZ5678")
    println(coche1)
    println(coche2)

    println("\n<<< Pruebas de creación inválida >>>")

    // Marca vacía
    try {
        val coche3 = Coche("Verde", "", "Focus", 100, 4, "AAA1111")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche con marca vacía: ${e.message}")
    }

    // Modelo vacío
    try {
        val coche4 = Coche("Negro", "Ford", "", 100, 4, "BBB2222")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche con modelo vacío: ${e.message}")
    }

    // Caballos fuera de rango
    try {
        val coche5 = Coche("Amarillo", "Seat", "Ibiza", 50, 4, "CCC3333")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche con caballos fuera de rango: ${e.message}")
    }

    // Puertas fuera de rango
    try {
        val coche6 = Coche("Blanco", "Fiat", "Punto", 100, 6, "DDD4444")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche con puertas fuera de rango: ${e.message}")
    }

    // Matrícula inválida
    try {
        val coche7 = Coche("Rojo", "Fiat", "Punto", 100, 4, "1234")
    } catch (e: IllegalArgumentException) {
        println("Error al crear coche con matrícula incorrecta: ${e.message}")
    }

    println("\n<<< Pruebas de modificación inválida >>>")

    val coche8 = Coche("Gris", "BMW", "X3", 200, 4, "EEE5555")

    // Intentar modificar color a vacío
    try {
        coche8.color = ""
    } catch (e: IllegalArgumentException) {
        println("Error al cambiar color: ${e.message}")
    }
}


