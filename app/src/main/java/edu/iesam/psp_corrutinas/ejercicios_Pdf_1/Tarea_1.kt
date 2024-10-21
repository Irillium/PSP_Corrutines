package edu.iesam.psp_corrutinas.ejercicios_Pdf_1

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val descarga: Deferred<String> = async {
            //he creado este valor para poner en
            // la funcion cuantas descargas/repeticiones se hacen
            val repeticiones=5
            repeat(repeticiones){
                //le paso el nombre del archivo, por cual repeticion va,
                // y cuantas descargas/repeticiones son
                descargar("Archivo",it.toInt(),repeticiones)
            }
            //Le doy este valor al terminar de descargar a $descarga
            "Descarga completada"
        }
        //espero x tiempo para "carcelar por tardar"
        delay(2000)
        //si al entrar el el bucle esta activo se interrumpe la ejecucion del defered
        while(descarga.isActive){
            descarga.cancel()
            println("Cancelando todas las descargas...")
        }

        //Compruebo al final si a podido completarse
        // o se ha tenido que cancelar el defered
        if (descarga.isCompleted){
            //imprimo su resultado para mas prueba de que ha terminado con exito
            println(descarga.await())
        }
        if (descarga.isCancelled){
            println("La descarga fue cancelada")
        }
    }

}
//Funcion que simula una descarga
suspend fun descargar(fileName:String,rep:Int,repeticiones:Int){
    val num = 0
    for(i in 0..2){
        delay(200)
        println( "Descargando $fileName${i}... ${rep+1}/$repeticiones")
    }
}