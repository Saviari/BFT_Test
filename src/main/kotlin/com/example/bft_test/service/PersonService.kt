package com.example.bft_test.service

import com.example.bft_test.dto.PersonDto

interface PersonService {

    fun getAll(): List<PersonDto>

    fun getById(id: Int): PersonDto

    fun getByName(name: String): List<PersonDto>

    fun getByLastName(lastName: String): List<PersonDto>

    fun create(dto: PersonDto): Int

    fun update(id: Int, dto: PersonDto)

    fun deleteById(id: Int)
}