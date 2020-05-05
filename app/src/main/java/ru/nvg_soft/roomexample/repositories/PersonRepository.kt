package ru.nvg_soft.roomexample.repositories

import android.app.Application

import androidx.lifecycle.LiveData

import ru.nvg_soft.roomexample.data.Person
import ru.nvg_soft.roomexample.data.database.Dao
import ru.nvg_soft.roomexample.data.database.PersonDatabase

class PersonRepository(applicationContext: Application):BaseRepository {
    private lateinit var personDao:Dao

    companion object{
        @Volatile private var INSTANCE : PersonRepository? = null

        fun getInstance(applicationContext: Application): PersonRepository{
            return INSTANCE ?: PersonRepository(applicationContext)
        }
    }
    init {
        val database = PersonDatabase.getInstance(applicationContext.applicationContext)
        personDao = database!!.personDao()
    }
    //region CRUD operation
    override fun insert(person: Person) = personDao.insertAllPerson(person)

    override fun update(person: Person) = personDao.updatePerson(person)

    override fun delete(person: Person) = personDao.deletePerson(person)

    override fun deleteAll() = personDao.deleteAll()

    fun getAll():LiveData<List<Person>> = personDao.getAllPersons()

    //end region
}