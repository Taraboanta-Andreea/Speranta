package com.sd.laborator;

import io.micronaut.function.executor.FunctionInitializer
import io.micronaut.function.FunctionBean;
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.function.Function;
import javax.inject.Inject

@FunctionBean("calcul-sir")
class CalculSirFunction : FunctionInitializer(), Function<CalculSirRequest, CalculSirResponse> {

    @Inject
    private lateinit var calculSirService: CalculSirService

    private var LOG: Logger = LoggerFactory.getLogger(CalculSirFunction::class.java)

    override fun apply(msg : CalculSirRequest) : CalculSirResponse {
        val number = msg.getNumber()

        val response = CalculSirResponse()

        if(number >= calculSirService.MAX_SIZE){
            LOG.error("Parametru prea mare! $number > maximul de ${calculSirService.MAX_SIZE}")
            response.setMessage("Se accepta doar parametrii mai mici ca ${calculSirService.MAX_SIZE}")
            return response
        }

        LOG.info("Se calculeaza primele $number elemente din sir...")

        // se calcuelaza si se seteaza proprietatile necesare
        response.setSir(calculSirService.createSirLessThan(number))
        response.setMessage("Calcul efectuat cu succes!")
        LOG.info("Calcul incheiat!")

        return response
    }   
}

/**
 * This main method allows running the function as a CLI application using: echo '{}' | java -jar function.jar 
 * where the argument to echo is the JSON to be parsed.
 */
fun main(args : Array<String>) { 
    val function = CalculSirFunction()
    function.run(args, { context -> function.apply(context.get(CalculSirRequest::class.java))})
}