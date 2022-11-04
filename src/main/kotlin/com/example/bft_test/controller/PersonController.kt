package com.example.bft_test.controller

import com.example.bft_test.dto.PersonDto
import com.example.bft_test.service.PersonService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/person")
class PersonController(
    private val personService: PersonService
) {
    @GetMapping()
    fun getAll(): List<PersonDto> = personService.getAll()

    @GetMapping("/id/{id}")
    fun getById(@PathVariable id: Int): PersonDto = personService.getById(id)

    @GetMapping("/name/{name}")
    fun getByName(@PathVariable name: String): List<PersonDto> = personService.getByName(name)

    @GetMapping("/lastName/{lastName}")
    fun getByLastName(@PathVariable lastName: String): List<PersonDto> = personService.getByLastName(lastName)

    @PostMapping
    fun create(@RequestBody dto: PersonDto): Int =
        personService.create(dto)

    @PutMapping("/id/{id}")
    fun update(@PathVariable id: Int, @RequestBody dto: PersonDto){
        personService.update(id, dto)
    }

    @DeleteMapping("/id/{id}")
    fun deleteById(@PathVariable id: Int){
        personService.deleteById(id)
    }
}