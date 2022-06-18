package com.example.digiobank.domain

import java.math.BigDecimal

data class Account(
    val agency:String,
    val accountNumber:String,
    val balance:BigDecimal
) {
    fun deposit(value:BigDecimal){
    }

    fun withdraw(value:BigDecimal){
    }
}