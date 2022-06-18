package com.example.digiobank.data

import com.example.digiobank.domain.Account
import com.example.digiobank.domain.Person
import java.math.BigDecimal

interface AccountRepository {
    fun getAccount(person: Person): List<Account>?
}