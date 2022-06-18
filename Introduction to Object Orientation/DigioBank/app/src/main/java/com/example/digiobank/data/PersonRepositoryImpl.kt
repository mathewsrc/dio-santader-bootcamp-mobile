package com.example.digiobank.data

import com.example.digiobank.domain.Person

object PersonDatabase {
    val persons = mapOf("123.123.123-11" to Person())
}

class PersonRepositoryImpl(private val personDatabase: PersonDatabase) : PersonRepository {

    override fun searchPersonBySocialId(socialId: String): Person {
        return personDatabase.persons.filter { it.key == socialId }.values.first()
    }
}