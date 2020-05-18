package ru.nvg_soft.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ru.nvg_soft.roomexample.data.Event
import ru.nvg_soft.roomexample.repositories.PersonRepository

class EventViewModel(application: Application):AndroidViewModel(application) {
    private val repository = PersonRepository.getInstance(application)
    private val events = repository!!.getAllEvent()
    fun getEventData():LiveData<List<Event>> {
        return  events
    }
}