class Rectangulo(val base:Double, val altura:Double) {

    fun calcular_area(): Double {
        return base * altura
    }

    fun calcular_perimetro():Double {
        return 2 * base + 2 * altura
    }

    override fun toString(): String {
        return "Rectangulo =(base=$base, altura=$altura)"
    }
}

fun main() {
    val rectangulo1 = Rectangulo(1.0, 2.0)
    val rectangulo2 = Rectangulo(2.0, 3.0)

    //mostrar rectangulos
    println(rectangulo1)
    println(rectangulo2)

    // mostrar sus áreas y perímetros
    println(rectangulo1.calcular_area())
    println(rectangulo1.calcular_perimetro())

    println(rectangulo2.calcular_area())
    println(rectangulo2.calcular_perimetro())
}