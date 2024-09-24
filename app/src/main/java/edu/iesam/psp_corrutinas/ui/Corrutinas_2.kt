package edu.iesam.psp_corrutinas.ui

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main(){
    val time = measureTimeMillis {
        runBlocking {
            println("Pronostico del tiempo")
            launch { //genera una nueva rama para ejecutar paralelamente a la rama principal
                val clima : Deferred<String> = async {
                    getForecast()
                }
            }
            launch {
                val temperatura : Deferred<String> = async {
                    getTemperature()
                }
            }
            println("¡Disfruta el dia!")//esto fuera del bloque se ejecuta respetando el orden
                                         // pero al estar dentro se ejecuta antes porque las ramas
                                        // paralelas generadas por el launch tienen delay
        }

    }
        println("El tiempo de ejecucion es de ${time / 1000.0} segundos")
}

suspend fun getForecast():String{
    delay(1000)
   return("Soleado")
}
suspend fun getTemperature():String{
    delay(1000)
    return("25ºC")
}