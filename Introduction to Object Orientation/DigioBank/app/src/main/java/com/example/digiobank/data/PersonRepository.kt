package com.example.digiobank.data

import com.example.digiobank.domain.Person

interface PersonRepository {
    fun searchPersonBySocialId(socialId: String):Person
}