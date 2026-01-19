
class Tiempo {

    var hora: Int
    var minuto: Int
    var segundo: Int

    constructor(hora: Int, minuto: Int, segundo: Int) {
        require(hora in 0..23) { "La hora debe estar entre 0 y 23" }

        val totalSegundos = minuto * 60 + segundo

        this.hora = hora
        this.minuto = (totalSegundos / 60) % 60
        this.segundo = totalSegundos % 60

        this.hora += totalSegundos / 3600
        require(this.hora <= 23) { "El tiempo supera las 23:59:59" }
    }

    constructor(hora: Int, minuto: Int) : this(hora, minuto, 0)

    constructor(hora: Int) : this(hora, 0, 0)

    fun incrementar(t:Tiempo):Boolean {
        var hrs = hora + t.hora
        var min = minuto + t.minuto
        var s = segundo + t.segundo

        min += s/60
        s %= 60
        hrs += min / 60
        min %= 60

        if (hrs > 23){
            return false
        }else{
            hora = hrs
            minuto = min
            segundo = s
            return true
        }
    }

    fun decrementar(t:Tiempo):Boolean {

        var hrs = hora - t.hora
        var min = minuto - t.minuto
        var s = segundo - t.segundo

        if (s < 0){
            s += 60
            min --
        }

        if (min < 0){
            min += 60
            hrs --
        }

        if (hrs < 0){
            return false
        }
        hora = hrs
        minuto = min
        segundo = s
        return true
    }

    fun comparar(t: Tiempo): Int {
        if (hora < t.hora) return -1
        if (hora > t.hora) return 1

        if (minuto < t.minuto) return -1
        if (minuto > t.minuto) return 1

        if (segundo < t.segundo) return -1
        if (segundo > t.segundo) return 1

        return 0
    }

    fun copiar(): Tiempo {
        return Tiempo(hora, minuto, segundo)
    }

    fun copiar(t: Tiempo): Tiempo {
        return Tiempo(t.hora, t.minuto, t.segundo)
    }

    fun sumar(t: Tiempo): Tiempo? {
        var hrs = hora + t.hora
        var min = minuto + t.minuto
        var s = segundo + t.segundo

        min += s / 60
        s %= 60

        hrs += min / 60
        min %= 60

        if (hrs > 23){
            return null
        }

        return Tiempo(hrs, min, s)
    }

    fun restar(t: Tiempo): Tiempo? {
        var h = hora - t.hora
        var m = minuto - t.minuto
        var s = segundo - t.segundo

        if (s < 0) {
            s += 60
            m--
        }

        if (m < 0) {
            m += 60
            h--
        }

        if (h < 0) return null

        return Tiempo(h, m, s)
    }

    fun esMayorQue(t:Tiempo):Boolean{
        return comparar(t) == 1
    }

    fun esMenorQue(t:Tiempo):Boolean{
        return comparar(t) == -1
    }

    override fun toString(): String {
        return "${hora}h ${minuto}m ${segundo}s"
    }
}

fun main() {

    println("<<< CREAR DE TIEMPOS >>>")
    val t1 = Tiempo(10, 30, 45)
    val t2 = Tiempo(2, 40, 30)

    println("Tiempo 1: $t1")
    println("Tiempo 2: $t2")

    println("\n<<< INCREMENTAR >>>")
    if (t1.incrementar(t2)) {
        println("Resultado: $t1")
    } else {
        println("Error: se supera 23:59:59")
    }

    println("\n<<< DECREMENTAR >>>")
    if (t1.decrementar(Tiempo(1, 20, 0))) {
        println("Resultado: $t1")
    } else {
        println("Error: se baja de 00:00:00")
    }

    println("\n<<< COMPARAR >>>")
    val resultado = t1.comparar(t2)
    println("Resultado comparar: $resultado")

    println("\n<<< COPIAR >>>")
    val copia = t1.copiar()
    println("Copia de t1: $copia")

    println("\n<<< SUMAR >>>")
    val suma = t1.sumar(t2)
    if (suma != null) {
        println("Suma: $suma")
    } else {
        println("Error: la suma supera 23:59:59")
    }

    println("\n<<< RESTAR >>>")
    val resta = t1.restar(t2)
    if (resta != null) {
        println("Resta: $resta")
    } else {
        println("Error: la resta baja de 00:00:00")
    }

    println("\n<<< COMPARACIONES BOOLEANAS >>>")
    println("t1 es mayor que t2: ${t1.esMayorQue(t2)}")
    println("t1 es menor que t2: ${t1.esMenorQue(t2)}")
}
