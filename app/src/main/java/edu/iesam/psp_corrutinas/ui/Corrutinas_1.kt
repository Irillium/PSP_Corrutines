package edu.iesam.psp_corrutinas.ui

import kotlinx.coroutines.*
import kotlin.system.*

fun main(){
   // println("Buenas")
    val time = measureTimeMillis { // para saber cuanto tarda en milisegundos
    runBlocking { //Función para ejecutar en bloque todo lo de dentro (como llamar a una funcion dentro de otra funcion)
            println("Pronostico del tiempo")
            clima()
            temperatura()
        }
    }
    println("El tiempo de ejecucion es de ${time / 1000.0} segundos")
}

suspend fun clima(){
    delay(1000)
    println("Soleado")
}

suspend fun temperatura(){
    delay(1000)
    println("20 ºC")
}