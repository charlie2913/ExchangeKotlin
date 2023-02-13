package software.architecture.demo.dto

class ResponseDto<T> {
    var data: T? = null
        private set
    var message: String? = null
    var isSuccess = false

    constructor(data: T, message: String?, success: Boolean) {
        this.data = data
        this.message = message
        isSuccess = success
    }

    constructor() {}

    fun setData(data: T) {
        this.data = data
    }

    override fun toString(): String {
        return "ResponseDto{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", success=" + isSuccess +
                '}'
    }
}