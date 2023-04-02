package software.architecture.demo.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import software.architecture.demo.bl.CurrencyBl
import software.architecture.demo.dto.CurrencyDto
import software.architecture.demo.dto.ResponseDto
import java.math.BigDecimal
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@RestController
@RequestMapping("api/v1/currency")
class CurrencyApi(private val currencyBl: CurrencyBl) {
    val logger : Logger = LoggerFactory.getLogger(CurrencyApi::class.java)
    @GetMapping("/list")
    fun list(
        @RequestParam page: Int,
        @RequestParam size: Int
    ): Any {
        val convertions = currencyBl.list(page, size);
        return ResponseEntity.ok(convertions)
    }
    @GetMapping("/exchange")
    @Throws(Exception::class)
    fun exchange(
        @RequestParam from: String,
        @RequestParam to: String,
        @RequestParam amount: BigDecimal
    ): ResponseEntity<Any> {
        logger.info("GET /api/v1/currency/convert - from:$from to:$to amount:$amount")
        val currencyDto: CurrencyDto = currencyBl.exchange(from, to, amount)
        //val response = ResponseDto(currencyDto, "Conversion Exitosa", true)
        logger.info("200 OK")
        return ResponseEntity.ok(currencyDto)
    }
    @GetMapping("/user")
    fun user(): String{
        logger.info("Iniciando servicio user")
        return "ROLE_USER"
    }
    @GetMapping("/admin")
    fun admin(): String{
        logger.info("Iniciando servicio admin")
        return "ROLE_ADMIN"
    }
}
