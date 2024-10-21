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
            println("Job 1 completado")
        }

        val job2 = launch {
            repeat(5) {
                enProceso(2, it)
            }
            println("Job 2 completado")
        }

        val job3 = launch {
            repeat(5) {
                enProceso(3, it)
            }
            println("Job 1 completado")
        }
        delay(1000)
        if (job2.isActive){
            job2.cancel()
            println("Cancelando tarea 2")
        }
        while ( job1.isActive ||job3.isActive ||job3.isActive ){
            println("Estado del job 1: ${job1.isActive}")
            println("Estado del job 1: ${job2.isActive}")
            println("Estado del job 1: ${job3.isActive}")
            delay(400)
        }
    }
}

suspend fun enProceso(nJob: Int, rep: Int) {
    println("El job $nJob esta en proceso...${rep + 1}/5")
    delay(500)
}