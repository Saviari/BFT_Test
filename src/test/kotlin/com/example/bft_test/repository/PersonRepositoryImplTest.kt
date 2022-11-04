package com.example.bft_test.repository

import com.example.bft_test.mock.MockDataSource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class PersonRepositoryImplTest {

    private val mockDataSource = MockDataSource()

    @Test
    fun getAll() {
        val persons = mockDataSource.getAll()
        Assertions.assertThat(persons).isNotEmpty
        Assertions.assertThat(persons).allMatch { it.name.isNotBlank() }
        Assertions.assertThat(persons).allMatch { it.lastName.isNotBlank() }
    }

    @Test
    fun getById() {
        val id = 10
        val persons = mockDataSource.getById(id)
        Assertions.assertThat(persons).isNotNull
    }

    @Test
    fun getByName() {
        val name = ""
        val persons = mockDataSource.getByName(name)
        Assertions.assertThat(persons).isNotNull
    }

    @Test
    fun getByLastName() {
        val lastName = ""
        val persons = mockDataSource.getByLastName(lastName)
        Assertions.assertThat(persons).isNotNull
    }
}