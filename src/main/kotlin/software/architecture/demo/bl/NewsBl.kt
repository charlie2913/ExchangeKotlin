package software.architecture.demo.bl

import com.fasterxml.jackson.databind.ObjectMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.architecture.demo.dao.CurrencyDao
import software.architecture.demo.dto.CurrencyDto
import software.architecture.demo.dto.NewsReqDto
import java.io.IOException
import java.math.BigDecimal
import java.util.*
@Service
class NewsBl  {
    companion object {
        private val objectMapper = ObjectMapper()
        private val LOGGER = LoggerFactory.getLogger(NewsBl::class.java)
    }
    @Value("\${news.url}")
    private val url: String? = null

    @Value("\${news.key}")
    private val key: String? = null

    @Throws(IOException::class)
    fun getNews(date: String): NewsReqDto {
        val client: OkHttpClient = OkHttpClient().newBuilder().build()
        val req: Request = Request.Builder()
            .url("$url?date=$date")
            .addHeader("apikey", key)
            .method("GET", null)
            .build()
        val response: Response = client.newCall(req).execute()
        val json: String = response.body().string()
        val mapper = ObjectMapper()

        return mapper.readValue(json,NewsReqDto::class.java)
    }
}
/*

class NewsBl : NewsMediator {
    @Autowired
    lateinit var newsMediator: NewsMediatorImpl

    companion object {
        private val objectMapper = ObjectMapper()
        private val LOGGER = LoggerFactory.getLogger(NewsBl::class.java)
    }
    @Value("\${news.url}")
    private val url: String? = null

    @Value("\${news.key}")
    private val key: String? = null

    @Throws(IOException::class)
    override fun getNews(date: String): NewsReqDto {
        return newsMediator.getNews(date)
    }
    /*
    fun getNews(date: String): NewsReqDto {
        val client: OkHttpClient = OkHttpClient().newBuilder().build()
        val req: Request = Request.Builder()
            .url("$url?date=$date")
            .addHeader("apikey", key)
            .method("GET", null)
            .build()
        val response: Response = client.newCall(req).execute()
        val json: String = response.body().string()
        val mapper = ObjectMapper()

        return mapper.readValue(json,NewsReqDto::class.java)
    }
    */

}

 */