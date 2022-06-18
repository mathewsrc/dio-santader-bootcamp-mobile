package com.example.digiobank

import androidx.lifecycle.ViewModel
import com.example.digiobank.data.BankDatabase
import com.example.digiobank.data.BankRepository
import com.example.digiobank.data.BankRepositoryImpl
import com.example.digiobank.domain.Bank
import com.example.digiobank.domain.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BankViewModel(private val bankRepository: BankRepository = BankRepositoryImpl(BankDatabase)) :
    ViewModel() {

    private val _bankFlow = MutableStateFlow<Bank?>(null)
    val bankFlow = _bankFlow.asStateFlow()

    fun searchBankByPerson(person: Person) {
        _bankFlow.value =  bankRepository.getBank(person)
    }

    init {
        searchBankByPerson(Person())
    }
}