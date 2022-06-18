package com.example.digiobank.data

import com.example.digiobank.domain.Bank
import com.example.digiobank.domain.Person

interface BankRepository {
    fun getBank(person: Person):Bank
}