package com.example.digiobank

import androidx.lifecycle.ViewModel
import com.example.digiobank.data.AccountRepository
import com.example.digiobank.data.AccountRepositoryImpl
import com.example.digiobank.data.AccountsDatabase
import com.example.digiobank.domain.Account
import com.example.digiobank.domain.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.math.BigDecimal

class AccountViewModel(
    private val accountRepository: AccountRepository = AccountRepositoryImpl(
        AccountsDatabase
    )
) : ViewModel() {

    private val _accountFlow = MutableStateFlow<List<Account>?>(null)
    val accountFlow = _accountFlow.asStateFlow()

    private val _showDepositMessage = MutableStateFlow<BigDecimal?>(null)
    val showDepositMessage = _showDepositMessage.asStateFlow()

    private val _showWithdrawMessage = MutableStateFlow<BigDecimal?>(null)
    val showWithdrawMessage = _showWithdrawMessage.asStateFlow()


    fun searchAccountByPerson(person: Person) {
        _accountFlow.value = accountRepository.getAccount(person)
    }

    fun deposit(accountId: String, value: BigDecimal) {
        // Simulate the deposit
        _accountFlow.value = accountFlow.value?.map {
            if (it.accountNumber == accountId) it.copy(balance = it.balance + value) else it
        }
        _showDepositMessage.value = value
    }

    fun withDraw(accountId: String, value: BigDecimal) {
        // Simulate the withDraw
        _accountFlow.value = accountFlow.value?.map {
            if (it.accountNumber == accountId) it.copy(balance = it.balance - value) else it
        }
        _showWithdrawMessage.value = value
    }


    init {
        searchAccountByPerson(Person())
    }
}