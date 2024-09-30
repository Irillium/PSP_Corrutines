package edu.iesam.psp_corrutinas

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Pronóstico del tiempo")
            val clima: Deferred<String> = async {
                try {
                    getForecast()
                } catch (e: Exception) {
                    "Excepción capturada en el clima: $e"
                }
            }
            val temperatura: Deferred<String> = async {
                try {
                    getTemperature()
                } catch (e: Exception) {
                    "Excepción capturada en la temperatura: $e"
                }
            }
            delay(200)
            temperatura.cancel()
            println("${clima.await()} ${temperatura.await()}")
            println("¡Disfruta el día!")
        }
    }

    println("El tiempo de ejecución es de ${time / 1000.0} segundos")
}

suspend fun getForecast(): String {
    delay(1000)
    return "Soleado"
}

suspend fun getTemperature(): String {
    delay(1000)
    return "25ºC"
}
