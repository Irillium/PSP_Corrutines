package edu.iesam.psp_corrutinas

import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun loG(message: String) {
    val formateador = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS")
    val hora = formateador.format(LocalDateTime.now())
    println("$hora - ${Thread.currentThread()} :: $message")

}

fun main() {
    loge("INICIO")
    runBlocking {
        val resultado = async {
            loG("Async : Estoy empezando")
            val a = (1..50).random()
            loG("Async : A = $a")
            delay(1000)
            val b = (1..50).random()
            loG("Async : B = $b")
            delay(1000)
            loG("Async : estoy acabando...")
            a + b
        }


        delay(100)
        while (resultado.isActive) {
            loG("RunBloking : Async esta activo")
            resultado.cancel()
            delay(1000)
        }


    }

}



