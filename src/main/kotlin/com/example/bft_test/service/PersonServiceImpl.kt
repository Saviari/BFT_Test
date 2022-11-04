package com.example.bft_test.service

import com.example.bft_test.dto.PersonDto
import com.example.bft_test.exception.*
import com.example.bft_test.model.Person
import com.example.bft_test.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(
    private val personRepository: PersonRepository
) : PersonService {
    override fun getAll(): List<PersonDto> {
        if (personRepository.getAll().isEmpty())
            throw TableIsEmptyException()
        else
            return personRepository.getAll().map { it.toDto() }
    }

    override fun getById(id: Int): PersonDto =
        personRepository.getById(id)
            ?.toDto()
            ?: throw PersonNotFoundException(id)

    override fun getByName(name: String): List<PersonDto> {
        if (personRepository.getByName(name).isEmpty())
            throw NameNotFoundException(name)
        else
            return personRepository.getByName(name).map { it.toDto() }
    }

    override fun getByLastName(lastName: String): List<PersonDto> {
        if (personRepository.getByLastName(lastName).isEmpty())
            throw LastNameNotFoundException(lastName)
        else
            return personRepository.getByLastName(lastName).map { it.toDto() }
    }

    override fun create(dto: PersonDto): Int =
        personRepository.create(dto.name, dto.lastName)

    override fun update(id: Int, dto: PersonDto) {
        if (personRepository.getById(id) == null)
            throw EntryIsEmptyException(id)
        else
            personRepository.update(id, dto.name, dto.lastName)
    }

    override fun deleteById(id: Int) {
        if (personRepository.getById(id) == null)
            throw EntryIsEmptyException(id)
        else
            personRepository.deleteById(id)
    }

    private fun Person.toDto() = PersonDto(
        id = id,
        name = name,
        lastName = lastName
    )
}