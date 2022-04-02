package com.sd.laborator

import io.micronaut.core.annotation.*
import javax.print.attribute.IntegerSyntax

@Introspected
class CalculSirRequest {
	lateinit var number: Integer

	fun getNumber(): Int{
		return number.toInt()
	}
}


