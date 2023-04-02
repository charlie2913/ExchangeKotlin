package software.architecture.demo.dto

data class ResponseDto<T> (
    var success: Boolean,
    var data: T,
    var message: String
)