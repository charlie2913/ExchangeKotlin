package software.architecture.demo.dto

class RequestDto {
    var from: String? = null
    var to: String? = null
    var amount: String? = null

    override fun toString(): String {
        return "RequestDto{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount='" + amount + '\'' +
                '}'
    }
}