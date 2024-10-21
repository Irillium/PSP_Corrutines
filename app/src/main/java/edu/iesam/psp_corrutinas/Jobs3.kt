package edu.iesam.psp_corrutinas

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

 fun loge(message: String) {
    val formateador = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS")
    val hora =  formateador.format(LocalDateTime.now())
    println("$hora - ${Thread.currentThread().name} :: $message")
}

fun main(){
    runBlocking {
        val api1= launch {
            llamadaApi("1",3000L)
        }
        val api2= launch {
            llamadaApi("2",4000L)
        }
        val api3= launch {
            llamadaApi("3",5000L)
        }
        delay(5000)
        when{
            api1.isActive-> {
                api1.cancel()
            loge("API 1 cancelado")
            }
            api2.isActive-> {
                api2.cancel()
                loge("API 2 cancelado")
            }
            api3.isActive->{
                api3.cancel()
                loge("API 3 cancelado")
            }
        }
    }

}
suspend fun llamadaApi(n:String, delay:Long){
    loge("Llamando a API $n ...")
    delay(delay)
    loge("API $n conectada")

}


