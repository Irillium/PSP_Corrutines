package edu.iesam.psp_corrutinas
import kotlinx.coroutines.*

fun main(){
    println("INICIO")

    runBlocking {
        val job = launch {
            repeat(10){
                println("Launch - repeticion #$it :: !Estoy activo¡")
                delay(1000)
            }
            println("Launch :: Estoy acabando.")
        }

        delay(2500)
        while (job.isActive){
            println("RunBlocking : Job está activo")
            delay(1000)
            println("RunBlocking : Cancelando el job")
            job.cancel()
        }
        if (job.isCancelled){
            println("RunBlocking : Job está cancelado")
        }else{
            println("RunBlocking : Job no está cancelado")
        }
        delay(500)//tarda en cancelarse/completarse
        if(job.isCompleted){
            println("RunBlocking : Job está COMPLETO!!")
        }
    }
}