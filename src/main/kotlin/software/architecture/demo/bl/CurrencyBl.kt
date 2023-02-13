package software.architecture.demo.bl

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.stereotype.Service
import software.architecture.demo.dto.CurrencyDto
import java.io.IOException
import java.math.BigDecimal


@Service
class CurrencyBl {
    @Throws(IOException::class)
    fun exchange(from: String, to: String, amount: BigDecimal): CurrencyDto {
        require(amount.compareTo(BigDecimal.ZERO) >= 0) { "Amount must be greater than 0" }
        val client: OkHttpClient = OkHttpClient().newBuilder().build()
        val req: Request = Request.Builder()
            .url("https://api.apilayer.com/exchangerates_data/convert?to=$to&from=$from&amount=$amount")
            .addHeader("apikey", "7kFsNWgEr4jIYz7i9I7l3TkzmvG572Wd")
            .build()
        val response: Response = client.newCall(req).execute()
        val json: String = response.body().string()
        val mapper = ObjectMapper()
        return mapper.readValue(json, CurrencyDto::class.java)
    }
}
