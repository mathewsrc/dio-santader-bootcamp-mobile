package com.example.digiobank

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

fun BigDecimal.convertToCurrency(): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.maximumFractionDigits = 0
    format.currency = Currency.getInstance(Locale.getDefault())
    return format.format(this.toLong())
}