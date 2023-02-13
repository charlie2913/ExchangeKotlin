package software.architecture.demo.dto

import java.math.BigDecimal


class CurrencyDto {
    var isSuccess = false
    var query: RequestDto? = null
    var info: DataDto? = null
    var date: String? = null
    var result: BigDecimal? = null

    constructor() {}
    constructor(success: Boolean, query: RequestDto?, info: DataDto?, date: String?, result: BigDecimal?) {
        isSuccess = success
        this.query = query
        this.info = info
        this.date = date
        this.result = result
    }

    override fun toString(): String {
        return "CurrencyDto{" +
                "success=" + isSuccess +
                ", query=" + query +
                ", info=" + info +
                ", date='" + date + '\'' +
                ", result=" + result +
                '}'
    }
}