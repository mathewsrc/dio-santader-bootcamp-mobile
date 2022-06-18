package com.example.digiobank

import androidx.lifecycle.ViewModel
import com.example.digiobank.data.PersonDatabase
import com.example.digiobank.data.PersonRepository
import com.example.digiobank.data.PersonRepositoryImpl
import com.example.digiobank.domain.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PersonViewModel(private val personRepository: PersonRepository = PersonRepositoryImpl(PersonDatabase)) :
    ViewModel() {

    private val _person = MutableStateFlow<Person?>(null)
    val person = _person.asStateFlow()

    fun searchPersonBySocialId(socialId: String) {
        _person.value = personRepository.searchPersonBySocialId(socialId)
    }

    init {
        searchPersonBySocialId("123.123.123-11")
    }

}