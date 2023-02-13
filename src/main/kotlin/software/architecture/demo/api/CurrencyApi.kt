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


@RestController
@RequestMapping("api/v1/currency")
class CurrencyApi(private val currencyBl: CurrencyBl) {
    @GetMapping("/exchange")
    @Throws(Exception::class)
    fun exchange(
        @RequestParam from: String,
        @RequestParam to: String,
        @RequestParam amount: BigDecimal
    ): ResponseEntity<ResponseDto<CurrencyDto>> {
        val currencyDto: CurrencyDto = currencyBl.exchange(from, to, amount)
        val responseDto: ResponseDto<CurrencyDto> = ResponseDto(currencyDto, "Success", true)
        return ResponseEntity.ok<ResponseDto<CurrencyDto>>(responseDto)
    }
}
