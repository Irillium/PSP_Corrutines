package edu.iesam.psp_corrutinas

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            val endPoints = listOf("API_1", "API_2", "API_3")
            val requests = endPoints.map { endPoint ->
                async { fechData(endPoint) }
            }
            requests.forEach { request ->
                println(request.await()) //await recupera valores
            }
        }
    }
    println("El tiempo de ejecucion es de ${time / 1000.0} segundos")
}
suspend fun fechData(endPoint:String): String{
    delay(2000)
    return "Datos de $endPoint "
}