enum class RangoIMC(val descripcion: String) {
    PESO_INSUFICIENTE("peso insuficiente"),
    PESO_SALUDABLE("peso saludable"),
    SOBREPESO("sobrepeso"),
    OBESIDAD("obesidad");

    companion object {
        fun desdeIMC(imc: Double): RangoIMC {
            return when {
                imc < 18.5 -> PESO_INSUFICIENTE
                imc < 25.0 -> PESO_SALUDABLE
                imc < 30.0 -> SOBREPESO
                else -> OBESIDAD
            }
        }
    }
}

class Persona2(var peso: Double, var altura: Double) {

    var nombre: String = ""

    val imc: Double
        get() = peso / (altura * altura)

    constructor(nombre: String, peso: Double, altura: Double) : this(peso, altura) {
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Persona(nombre='$nombre', peso=$peso, altura=$altura, imc=$imc)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other::class != Persona::class) return false
        val otraPersona = other as Persona
        return nombre == otraPersona.nombre
    }

    fun saludar(): String {
        return "Hola, mi nombre es $nombre."
    }

    fun alturaEncimaMedia(): Boolean {
        return altura >= 1.75
    }

    fun pesoEncimaMedia(): Boolean {
        return peso >= 70
    }

    fun obtenerDescIMC(): String {
        return RangoIMC.desdeIMC(imc).descripcion
    }

    fun obtenerDesc(): String {
        val alturaDesc = if (alturaEncimaMedia()) "Por encima de la media" else "Por debajo de la media"
        val pesoDesc = if (pesoEncimaMedia()) "Por encima de la media" else "Por debajo de la media"
        val imcDesc = obtenerDescIMC()
        return "$nombre con una altura de %.2fm ($alturaDesc) y un peso %.1fkg ($pesoDesc) tiene un IMC de %.2f ($imcDesc)".format(altura, peso, imc)
    }
}


fun main() {

    val personas = arrayOf(
        Persona2("Julia", 64.7, 1.72),
        Persona2("Pedro", 85.0, 1.80),
        Persona2("Ana", 50.0, 1.60),
        Persona2("Carlos", 95.0, 1.75),
        Persona2("Lucía", 70.0, 1.68)
    )

    for (persona in personas) {
        println(persona.saludar())
        println(persona.obtenerDesc())
        println()
    }
}
