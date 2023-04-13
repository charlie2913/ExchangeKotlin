package software.architecture.demo.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import software.architecture.demo.bl.CurrencyBl
import software.architecture.demo.bl.NewsBl
//import software.architecture.demo.bl.NewsMediator
//import software.architecture.demo.bl.NewsMediatorImpl
import software.architecture.demo.dto.CurrencyDto
import software.architecture.demo.dto.NewsReqDto
import java.math.BigDecimal

@RestController
@RequestMapping("api/v1/news")
class NewsApi (private val newsBl: NewsBl) {
    val logger : Logger = LoggerFactory.getLogger(CurrencyApi::class.java)
    @GetMapping("/view")
    @Throws(Exception::class)
    fun view(
        @RequestParam date: String,
    ): ResponseEntity<Any> {
        logger.info("GET /api/v1/currency/convert - date:$date")
        val newsReqDto: NewsReqDto = newsBl.getNews(date)
        //val response = ResponseDto(currencyDto, "Conversion Exitosa", true)
        logger.info("200 OK")
        return ResponseEntity.ok(newsReqDto)
    }
}

/*
@RestController
@RequestMapping("api/v1/news")
class NewsApi (@Qualifier("newsMediatorImpl")private val newsMediator: NewsMediator) {
    val logger : Logger = LoggerFactory.getLogger(CurrencyApi::class.java)
    @GetMapping("/view")
    @Throws(Exception::class)
    fun view(
        @RequestParam date: String,
    ): ResponseEntity<Any> {
        logger.info("GET /api/v1/currency/convert - date:$date")
        val newsReqDto: NewsReqDto = newsMediator.getNews(date)
        //val response = ResponseDto(currencyDto, "Conversion Exitosa", true)
        logger.info("200 OK")
        return ResponseEntity.ok(newsReqDto)
    }
}

 */