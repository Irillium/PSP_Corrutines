package edu.iesam.psp_corrutinas.ejercicios_Pdf_1

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        //Creo 3 defered que simulan 3 reservas con diferentes delays
        val reserva1 :  Deferred<String> = async {
            //se pasa por parametro el numero de habitacion y el delay que tendra
            reserveRoom(101,100)
        }
        val reserva2 :  Deferred<String> = async {
            //este tiene un tiempo mas largo para ser cancelado despues
            reserveRoom(102,500)
        }
        val reserva3 :  Deferred<String> = async {
            reserveRoom(103,200)
        }
        //espero 1,5 segundos
        delay(1500)
        //pregunto si alguna esta activa y la cancelo
        when{
            reserva1.isActive->{reserva1.cancel()
            println("Cancelando la reserva de la habitacio 101")
            }
            reserva2.isActive->{reserva2.cancel()
                println("Cancelando la reserva de la habitacio 102")
            }
            reserva3.isActive->{reserva3.cancel()
                println("Cancelando la reserva de la habitacio 103")
            }
        }
        // paso por un try-catch el resultado de cada defered
        // para que si se ha cancelado se refleje por su ausencia
        //de datos( que manda una excepcion)
        // y si ha terminado bien imprima su resultado
        try {
            println(reserva1.await())
        } catch (e: CancellationException) {
            println("Reserva 101 fue cancelada.")
        }

        try {
            println(reserva2.await())
        } catch (e: CancellationException) {
            println("Reserva 102 fue cancelada.")
        }

        try {
            println(reserva3.await())
        } catch (e: CancellationException) {
            println("Reserva 103 fue cancelada.")
        }
    }
}
//metodo para "reservar una habitacion"
suspend fun reserveRoom(nRoom: Int,delay: Long): String {
    for (i in 1..5) {
        println("Reservando habitacion $nRoom...$i/5")
        delay(delay)
    }
    return "Habitacion $nRoom reservada"
}