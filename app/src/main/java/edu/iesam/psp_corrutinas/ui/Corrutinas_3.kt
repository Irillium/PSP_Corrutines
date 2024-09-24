package edu.iesam.psp_corrutinas.ui

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main(){
    val time = measureTimeMillis {
        runBlocking {
            println("Pronostico del tiempo")
            val clima: Deferred<String> = async { getForecast() }
            val temperatura: Deferred<String> = async { getTemperature() }
            println("${clima.await()} ${temperatura.await()}")
            println("¡Disfruta el dia!")
        }
    }
    println("El tiempo de ejecucion es de ${time / 1000.0} segundos")

}

suspend fun getForecast(): String{
    delay(1000)
    return("Soleado")
}
suspend fun getTemperature(): String{
    delay(1000)
    return("25ºC")
}