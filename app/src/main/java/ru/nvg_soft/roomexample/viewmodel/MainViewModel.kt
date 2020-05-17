package ru.nvg_soft.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ru.nvg_soft.roomexample.data.Person

import ru.nvg_soft.roomexample.repositories.PersonRepository

class MainViewModel(application: Application): AndroidViewModel(application) {

    private val repository = PersonRepository.getInstance(application)
    private val persons = repository!!.getAll()




    fun getPersonData():LiveData<List<Person>>{

        return persons
    }
}