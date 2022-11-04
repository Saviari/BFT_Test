package com.example.bft_test.repository

import com.example.bft_test.model.Person

interface PersonRepository {

    fun getAll(): List<Person>

    fun getById(id: Int): Person?

    fun getByName(name: String): List<Person>

    fun getByLastName(lastName: String): List<Person>

    fun create(name: String, lastName: String): Int

    fun update(id: Int, name: String, lastName: String)

    fun deleteById(id: Int)
}