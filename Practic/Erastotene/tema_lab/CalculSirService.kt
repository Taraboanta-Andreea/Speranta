package com.sd.laborator

import java.util.*
import javax.inject.Singleton

@Singleton
class CalculSirService {
    val MAX_SIZE = 1000001

    fun createSirLessThan(n: Int): List<Int>{
        val sir: MutableList<Int> = ArrayList()
        sir.add(1)
        for (i in 1 until n){
            val nextElement = sir[i-1] + 2 * sir[i-1]/i
            sir.add(nextElement)
        }
        return sir
    }

    init {
        // do nothing
    }
}