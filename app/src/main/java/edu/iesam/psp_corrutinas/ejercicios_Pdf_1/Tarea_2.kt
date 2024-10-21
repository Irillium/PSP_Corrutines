package edu.iesam.psp_corrutinas.ejercicios_Pdf_1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        val factorial_1: Deferred<Long> = async {
            val n=7 //guardo el numero en una variable para poder despues imprimirlo por pantalla
            val f= factorial(n)//llamo al metodo que factoriza y le meto el numero elegido y lo guardo en una variable
            println("El factorial de $n es $f") //imprimmo que numero he factorrizado y el resultado de la factorizacion
            f//devuelvo el resultado de factorizar
        }
        //y asi con los demas..
        val factorial_2: Deferred<Long> = async {
            val n=13
            val f= factorial(n)
            println("El factorial de $n es $f")
            f
        }
        val factorial_3: Deferred<Long> = async {
            val n=4
            val f= factorial(n)
            println("El factorial de $n es $f")
            f
        }
    }
}


//Función para calcular el factorial
suspend fun factorial(n: Int): Long {
    var result = 1L  // Usamos Long para soportar números grandes
    for (i in 1..n) {
        result *= i
    }
    return result
}