package edu.iesam.psp_corrutinas

import kotlinx.coroutines.*

fun main() {
    log("INICIO")
    runBlocking {
        val resultado = async {
            log("Async : Estoy llamando a la Api")
            delay(3000)
            log("Async : estoy acabando...")
            "API conectada"
        }
        delay(1000)
        while (resultado.isActive) {
            log("RunBloking : Async esta activo")
            resultado.cancel()
            delay(1000)
        }
        val result = try {
            resultado.await()
        }catch (e:CancellationException){
            log("La api tardo demasiado")
        }

    }

}



