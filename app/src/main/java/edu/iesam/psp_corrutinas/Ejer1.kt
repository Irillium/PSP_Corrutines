package edu.iesam.psp_corrutinas

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            val files = listOf("Archivo1", "Archivo2", "Archivo3")
            val downloads = files.map { file ->
                async { downloadFile(file) }
            }
            downloads.forEach { download ->
                println(download.await()) //await recupera valores
            }
        }
    }
    println("El tiempo de ejecucion es de ${time / 1000.0} segundos")
}
suspend fun downloadFile(fileName:String): String{
    delay(2000)
    return "$fileName descargado"
}