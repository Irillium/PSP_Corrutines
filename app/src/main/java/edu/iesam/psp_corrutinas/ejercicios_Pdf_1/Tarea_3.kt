package edu.iesam.psp_corrutinas.ejercicios_Pdf_1

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            repeat(5) {
                enProceso(1, it)
            }

        }

        val job2 = launch {
            repeat(5) {
                enProceso(2, it)
            }
        }

        val job3 = launch {
            repeat(5) {
                enProceso(3, it)
            }
        }
        delay(2500)
        while (job2.isActive){
            job2.cancel()
            println("Cancelando tarea 2")
        }
    }
}

suspend fun enProceso(nJob: Int, rep: Int) {
    println("El job $nJob esta en proceso...${rep + 1}/5")
    delay(500)
}