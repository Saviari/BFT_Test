package com.example.bft_test.repository

import com.example.bft_test.model.Person
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

@Repository
class PersonRepositoryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : PersonRepository {

    override fun getAll(): List<Person> =
    jdbcTemplate.query(
        "select * from person order by id",
        ROW_MAPPER
    )

    override fun getById(id: Int): Person? =
        jdbcTemplate.query(
            "select * from person where id = :id",
            mapOf(
                "id" to id
            ),
            ROW_MAPPER
        ).firstOrNull()

    override fun getByName(name: String): List<Person> =
        jdbcTemplate.query(
            "select * from person where name = :name",
            mapOf(
                "name" to name
            ),
            ROW_MAPPER
        )

    override fun getByLastName(lastName: String): List<Person> =
        jdbcTemplate.query(
            "select * from person where lastName = :lastName",
            mapOf(
                "lastName" to lastName
            ),
            ROW_MAPPER
        )

    override fun create(name: String, lastName: String): Int {
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(
            "insert into person (name, lastName) values (:name, :lastName)",
            MapSqlParameterSource(
                mapOf(
                    "name" to name,
                    "lastName" to lastName
                )
            ),
            keyHolder,
            listOf("id").toTypedArray()
        )
        return keyHolder.keys?.getValue("id") as Int
    }

    override fun update(id: Int, name: String, lastName: String) {
        jdbcTemplate.update(
            "update person set name = :name, lastName = :lastName where id = :id",
            mapOf(
                "id" to id,
                "name" to name,
                "lastName" to lastName
            )
        )
    }

    override fun deleteById(id: Int) {
        jdbcTemplate.update(
            "delete from person where id = :id",
            mapOf(
                "id" to id
            )
        )
    }

    private companion object {
        val ROW_MAPPER = RowMapper<Person> { rs, _ ->
            Person(
                id = rs.getInt("id"),
                name = rs.getString("name"),
                lastName = rs.getString("lastName")
            )
        }
    }
}