package ru.nvg_soft.roomexample.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import androidx.room.Dao
import ru.nvg_soft.roomexample.data.Event
import ru.nvg_soft.roomexample.data.Person


@Dao
interface Dao {
        @Query("SELECT * FROM person ORDER BY name")
        fun getAllPersons(): LiveData<List<Person>>


    @Query("SELECT * FROM person WHERE personId IN (:personIds)")
    fun loadAllPersonByIds(personIds: IntArray): List<Person>



    @Query("SELECT * FROM person WHERE name LIKE :name")
    fun findPersonByName(name: String): Person

    @Insert
    suspend fun insertAllPerson(vararg person: Person)


    @Delete
    fun deletePerson(person: Person)

    @Update
    fun updatePerson(person: Person)

    @Query("DELETE FROM person")
    fun deleteAll()

    //Event
    @Query("SELECT * FROM event")
    fun getAllEvent():LiveData<List<Event>>

    @Insert
    suspend fun insertEvent(vararg event: Event)

}