package com.example.bft_test.mock

import com.example.bft_test.dto.PersonDto
import com.example.bft_test.service.PersonService
import org.springframework.stereotype.Repository

@Repository
class MockDataSource : PersonService {
    val persons = listOf(
        PersonDto(1, "Boris", "Schukin"),
        PersonDto(2, "Boris", "Shpagin"),
        PersonDto(3, "Ivan", "Ivanov"),
        PersonDto(4, "Maria", "Petrova"),
        //PersonDto(5, "", "")
    )

    override fun getAll(): List<PersonDto> {
        return persons
    }

    override fun getById(id: Int): PersonDto {
        val idMock = 0
        return persons[idMock]
    }

    override fun getByName(name: String): List<PersonDto> {
        return persons
    }

    override fun getByLastName(lastName: String): List<PersonDto> {
        return persons
    }

    override fun create(dto: PersonDto): Int {
        TODO("Not yet implemented")
    }

    override fun update(id: Int, dto: PersonDto) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }
}