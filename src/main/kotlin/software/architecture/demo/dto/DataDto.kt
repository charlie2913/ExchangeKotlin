package software.architecture.demo.dto

import java.math.BigDecimal
import java.math.BigInteger


class DataDto {
    var timestamp: BigInteger? = null
    var rate: BigDecimal? = null

    constructor(timestamp: BigInteger?, rate: BigDecimal?) {
        this.timestamp = timestamp
        this.rate = rate
    }

    constructor() {}

    override fun toString(): String {
        return "DataDto{" +
                "timestamp=" + timestamp +
                ", rate=" + rate +
                '}'
    }
}