package edu.iesam.psp_corrutinas

import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun log(message: String) {
    val formateador = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS")
    val hora =  formateador.format(LocalDateTime.now())
    println("$hora - ${Thread.currentThread().name} :: $message")
}

fun main() {
    println("\t \t \t INICIO")

    runBlocking {
        val job1 = launch {
            val hijoJob1 = launch {
                repeat(5) {
                    log("hhh hhh hhh hijoJob1 -> iteración $it")
                    delay(1000)
                }
                log("hhh hhh hhh HIJO JOB1 Acaba")
            }
            log("111 111 JOB1 Acaba")
        }
        delay(100)
        val job2 = launch {

            repeat(3) {
                log("222 222  Job2 -> iteración $it")
                delay(1000)
            }
            log("222 222 JOB2 Acaba")
        }
        delay(200)
        while (job1.isActive || job2.isActive){
            log("JOB1 :: ${job1.isActive} XXX JOB2 :: ${job2.isActive}")
            delay(1000)
        }
    }
    log("FIN")
}
