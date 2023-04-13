package software.architecture.demo.bl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Service
import software.architecture.demo.dto.NewsReqDto
/*
@Primary
@Service
class NewsMediatorImpl : NewsMediator {
    @Autowired
    lateinit var newsBl: NewsBl
    override fun getNews(date: String): NewsReqDto {
        return newsBl.getNews(date)
    }
}
*/