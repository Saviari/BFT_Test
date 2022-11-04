package com.example.bft_test.exception

import org.springframework.http.HttpStatus

abstract class BaseException(
    val errorCode: String,
    override val message: String,
    val status: HttpStatus
): RuntimeException(message)

class TableIsEmptyException(): BaseException(
    errorCode = "table.is.empty",
    message = "Table is empty",
    status = HttpStatus.NOT_FOUND
)

class PersonNotFoundException(id: Int): BaseException(
    errorCode = "person.not.found",
    message = "Person with id = $id was not found",
    status = HttpStatus.NOT_FOUND
)

class NameNotFoundException(name: String): BaseException(
    errorCode = "name.not.found",
    message = "Person with name = $name was not found",
    status = HttpStatus.NOT_FOUND
)

class LastNameNotFoundException(lastName: String): BaseException(
    errorCode = "lastname.not.found",
    message = "Person with lastname = $lastName was not found",
    status = HttpStatus.NOT_FOUND
)

class EntryIsEmptyException(id: Int): BaseException(
    errorCode = "entry.is.empty",
    message = "There is no entry with id = $id",
    status = HttpStatus.NOT_FOUND
)