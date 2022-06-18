package com.example.digiobank.data

import com.example.digiobank.Account
import com.example.digiobank.domain.Account
import com.example.digiobank.domain.Person
import java.math.BigDecimal

/**
 * Simulates a Database such as SQL, FirebaseFirestore, etc.
 */
object AccountsDatabase {
    val accounts = mapOf("123.123.123-11" to Account("123", "123.123.123-11", BigDecimal.valueOf(89352985)))

}

class AccountRepositoryImpl(private val accountsDatabase:AccountsDatabase):AccountRepository {

    override fun getAccount(person: Person): List<Account> {
        val id = person.socialId
        return accountsDatabase.accounts.filter { it.key == id }.values.toList()
    }
}