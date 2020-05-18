package ru.nvg_soft.roomexample.repositories

import android.app.Application

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nvg_soft.roomexample.data.Event

import ru.nvg_soft.roomexample.data.Person
import ru.nvg_soft.roomexample.data.database.Dao
import ru.nvg_soft.roomexample.data.database.PersonDatabase

class PersonRepository(applicationContext: Application) {
    private lateinit var dao:Dao

    companion object{
        @Volatile private var INSTANCE : PersonRepository? = null

        fun getInstance(applicationContext: Application): PersonRepository?{
            if(INSTANCE==null){
            synchronized(PersonRepository::class){
                INSTANCE = PersonRepository(applicationContext)}
        }
            return INSTANCE}
    }
    init {
        val database = PersonDatabase.getInstance(applicationContext.applicationContext)
        dao = database!!.personDao()
    }
    //region CRUD operation
    suspend fun insertPerson(person: Person) = withContext(Dispatchers.IO){dao.insertAllPerson(person)}

    suspend fun updatePerson(person: Person) = withContext(Dispatchers.IO){dao.updatePerson(person)}

     suspend fun deletePerson(person: Person) = withContext(Dispatchers.IO){dao.deletePerson(person)}

     suspend fun deleteAllPerson() = withContext(Dispatchers.IO){dao.deleteAll()}

    fun getAllPerson():LiveData<List<Person>> = dao.getAllPersons()

    //end region

    fun getAllEvent():LiveData<List<Event>> = dao.getAllEvent()

    suspend fun insertEvent(event: Event) = withContext(Dispatchers.IO){dao.insertEvent(event)}
}