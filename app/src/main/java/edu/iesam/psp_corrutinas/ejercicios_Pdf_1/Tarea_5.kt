package edu.iesam.psp_corrutinas.ejercicios_Pdf_1

import kotlinx.coroutines.runBlocking
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitString
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

fun main() {
    runBlocking {
        // Crear trabajos para cada consulta API
        val catFactJob = getCatFact()
        val dogImageJob = getDogImage()
        val activityJob = getActivity()
        val bitcoinPriceJob = getBitcoinPrice()
        val randomUserJob = getRandomUser()

        try {
            // Realizar las consultas en paralelo
            val catFact = catFactJob.await()
            val dogImage = dogImageJob.await()
            val activity = activityJob.await()
            val bitcoinPrice = bitcoinPriceJob.await()
            val randomUser = randomUserJob.await()

            // Mostrar los resultados
            println("Cat Fact: $catFact")
            println("Dog Image: $dogImage")
            println("Activity: $activity")
            println("Bitcoin Price: $bitcoinPrice")
            println("Random User: $randomUser")
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }

        // Manejar la cancelación
        // Puedes cancelar las corrutinas si lo necesitas
        // Ejemplo: catFactJob.cancel()
    }
}

suspend fun getCatFact(): Deferred<String> = GlobalScope.async {
    val response = Fuel.get("https://catfact.ninja/fact").awaitString()
    response
}
suspend fun getDogImage(): Deferred<String> = GlobalScope.async {
    val response = Fuel.get("https://dog.ceo/api/breeds/image/random").awaitString()
    response
}
suspend fun getActivity(): Deferred<String> = GlobalScope.async {
    val response = Fuel.get("https://www.boredapi.com/api/activity").awaitString()
    response
}
suspend fun getBitcoinPrice(): Deferred<String> = GlobalScope.async {
    val response = Fuel.get("https://api.coindesk.com/v1/bpi/currentprice/BTC.json").awaitString()
    response
}
suspend fun getRandomUser(): Deferred<String> = GlobalScope.async {
    val response = Fuel.get("https://randomuser.me/api/").awaitString()
    response
}
