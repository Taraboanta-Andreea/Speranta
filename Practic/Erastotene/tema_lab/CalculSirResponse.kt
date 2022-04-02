package com.sd.laborator

import io.micronaut.core.annotation.*
import javax.print.attribute.IntegerSyntax

@Introspected
class CalculSirResponse {
	private var message: String? = null
	private var sir:List<Int>? = null

	fun getSir() : List<Int>? {
		return sir
	}
	fun setSir(sir: List<Int>?){
		this.sir = sir
	}
	fun getMessage():String?{
		return message
	}
	fun setMessage(message: String?){
		this.message = message
	}
}


