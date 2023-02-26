package software.architecture.demo.dao

import java.math.BigDecimal
import java.util.*
import javax.persistence.*
@Entity
@Table(name = "currency")
class CurrencyDao (
    var currencyFrom: String,
    var currencyTo: String,
    var amount: BigDecimal,
    var result: BigDecimal,
    var date: Date,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
) {
    constructor() : this("", "", BigDecimal.ZERO, BigDecimal.ZERO, Date()) {
    }
}