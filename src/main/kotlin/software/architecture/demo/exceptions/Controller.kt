package software.architecture.demo.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import software.architecture.demo.dto.ResponseDto


@ControllerAdvice
class Controller {
    @ExceptionHandler(IllegalArgumentException::class)
    fun zeroException(e: IllegalArgumentException): ResponseEntity<ResponseDto<*>> {
        val responseDto: ResponseDto<*> = ResponseDto<Any?>(false, 0, e.message.toString() )
        return ResponseEntity.badRequest().body(responseDto)
    }
}