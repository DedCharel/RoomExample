package ru.nvg_soft.roomexample.repositories

import android.app.Application

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
    override suspend fun insert(person: Person) = withContext(Dispatchers.IO){personDao.insertAllPerson(person)}

    override suspend fun update(person: Person) = withContext(Dispatchers.IO){personDao.updatePerson(person)}

    override suspend fun delete(person: Person) = withContext(Dispatchers.IO){personDao.deletePerson(person)}

    override suspend fun deleteAll() = withContext(Dispatchers.IO){personDao.deleteAll()}

    fun getAll():LiveData<List<Person>> = personDao.getAllPersons()

    //end region
}