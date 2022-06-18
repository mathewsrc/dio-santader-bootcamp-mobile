package com.example.digiobank.data

import com.example.digiobank.domain.Bank
import com.example.digiobank.domain.Person

/**
 * Simulates a Database such as SQL, FirebaseFirestore, etc.
 */
object BankDatabase {
    val banks = mapOf("123.123.123-11" to Bank("DigioOneBank", 2022))
}

class BankRepositoryImpl(private val bankDatabase: BankDatabase) : BankRepository {
    override fun getBank(person: Person): Bank {
        val personId = person.socialId
        return bankDatabase.banks.filter { it.key == personId }.values.first()
    }
}