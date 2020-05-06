package ru.nvg_soft.roomexample.repositories

import ru.nvg_soft.roomexample.data.Person

interface BaseRepository {
   suspend fun insert(person: Person)

    suspend fun update(person: Person)

    suspend fun delete(person: Person)

   suspend fun deleteAll()
}