class Persona(var peso:Double, var altura:Double) {

    var nombre:String = ""
    val imc:Double
        get() = peso / (altura*altura)

    constructor(nombre:String, peso:Double, altura: Double):this(peso, altura){
        this.nombre = nombre
    }

    override fun toString(): String {
        return "Persona(nombre='$nombre', peso=$peso, altura=$altura, imc=$imc)"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other::class != Persona::class) return false
        return this.nombre == (other as Persona).nombre
    }

}

fun pedir_nombre():String{

    var nombre = ""

    do {
        print("Introduzca que nombre quieres asignarle a la persona1:")
        nombre = readln()
    }while (nombre == "")

    return nombre
}

fun main() {

    var persona1 = Persona(82.0,1.87)
    var persona3 = Persona("pepe", 40.0, 1.39)
    var persona2 = Persona("juan", 92.0, 1.69) //constructor secundario

    // persona1
    persona1.nombre = pedir_nombre()
    print("nombre = ${persona1.nombre}, peso= ${persona1.peso}, altura= ${persona1.altura}")

    // persona3
    println("peso= ${persona3.peso}, altura= ${persona3.altura}, imc= ${persona3.imc}")
    persona3.altura = 1.80
    println("peso= ${persona3.peso}, altura= ${persona3.altura}, imc= ${persona3.imc}")

    // persona2
    persona2.altura = persona3.altura
    println(persona2)
    println(persona3)
    println(persona2 == persona3)
    println(persona2.equals(persona3))
}