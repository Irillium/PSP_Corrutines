package edu.iesam.psp_corrutinas.ejercicios_Pdf_1

import kotlinx.coroutines.*

fun main(){
    runBlocking {

    }

}

/*
* Tarea 1: Simulación de Descarga de Archivos
*
    Descripción
    *
    Crea una aplicación que simule la descarga de varios archivos en paralelo utilizando
    corrutinas. Cada descarga debe ser una función suspend que retorne un Deferred con el
    resultado de la descarga. La aplicación debe mostrar el progreso de cada descarga y
    permitir cancelar todas las descargas en cualquier momento.
    Un ejemplo de la ejecución puede ser esta:
    La cancelación se puede hacer directamente en el código desde el punto que se quiera.
    Un ejemplo de simulación de descarga puede ser:
         repeat(5) {
         delay(500)
         println("Descargando $fileName... ${it + 1}/5")
         }
*/