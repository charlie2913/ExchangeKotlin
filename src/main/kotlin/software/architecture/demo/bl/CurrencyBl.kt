package software.architecture.demo.bl

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.architecture.demo.dao.CurrencyDao
import software.architecture.demo.dto.CurrencyDto
import java.io.IOException
import java.math.BigDecimal
import org.springframework.data.domain.PageRequest
import software.architecture.demo.dao.Repository.CurrenciesRepository
import software.architecture.demo.dto.RequestDto

import java.util.*


@Service
class CurrencyBl @Autowired constructor(private val currenciesRepository: CurrenciesRepository) {
companion object {
        private val objectMapper = ObjectMapper()
        private val LOGGER = LoggerFactory.getLogger(CurrencyBl::class.java)
    }

    @Value("\${currency.url}")
    private val url: String? = null

    @Value("\${currency.key}")
    private val key: String? = null

    fun list(page: Int, size: Int): Any {
        val currencies = currenciesRepository.findAll(PageRequest.of(page, size))
        return currencies
    }

    @Throws(IOException::class)
    fun exchange(from: String, to: String, amount: BigDecimal): CurrencyDto {
        require(amount.compareTo(BigDecimal.ZERO) >= 0) { "Amount must be greater than 0" }
        val client: OkHttpClient = OkHttpClient().newBuilder().build()
        val req: Request = Request.Builder()
            .url("$url?to=$to&from=$from&amount=$amount")
            .addHeader("apikey", key)
            .build()
        val response: Response = client.newCall(req).execute()

        val json: String = response.body().string()
        if(response.isSuccessful){

            val currencyDto = objectMapper.readValue(json, CurrencyDto::class.java)
            val currency: CurrencyDao = CurrencyDao()
            currency.currencyFrom = from
            currency.currencyTo = to
            currency.amount = amount
            currency.result = currencyDto.result!!
            currency.date = Date()
            currenciesRepository.save(currency)
            LOGGER.info("Conversion result: ${json}")
        }
        val mapper = ObjectMapper()

        return mapper.readValue(json, CurrencyDto::class.java)
    }
}
