package ru.nvg_soft.roomexample.repositories

import ru.nvg_soft.roomexample.data.Person

interface BaseRepository {
    fun insert(person: Person)

    fun update(person: Person)

    fun delete(person: Person)

    fun deleteAll()
}