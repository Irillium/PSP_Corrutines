package edu.iesam.psp_corrutinas

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    runBlocking {
        println("Funcion runBloquing:: ${Thread.currentThread().name}")
        launch {
            println("Dentro de launch:: ${Thread.currentThread().name}")
            withContext(Dispatchers.Default){
                println("Dentro de withContext:: ${Thread.currentThread().name}")
                delay(2000)
                println("Encontrados 10 resultados de busqueda")
            }
            println("Fin del launch:: ${Thread.currentThread().name}")
        }
    }
    println("Fuera del runBloquing:: ${Thread.currentThread().name}")
    println("Cargando...")
}