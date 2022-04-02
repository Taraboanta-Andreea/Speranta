package com.sd.laborator

import jakarta.inject.Singleton
import java.util.*

@Singleton
class EratosteneSieveService {

    val A: MutableList<Int> = ArrayList(10)

    fun suma(A:MutableList<Int>, k: Int):Int{
        var s:Int=0
        for (i in 0 until k+1)
            s+=A[i]*A[i]

        return s
    }
    fun crearesir(): List<Int> {

        val B: MutableList<Int> = ArrayList(10)

        for (i in 0 until 10) {
            var x = (Math.random() * 100).toInt()
            A.add(x)
        }

        for (i in 0 until 10)
            B.add(suma(A,i))

        return B
    }
}