package ru.nvg_soft.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nvg_soft.roomexample.data.Event
import ru.nvg_soft.roomexample.repositories.PersonRepository

class AddEventModel(application: Application):AndroidViewModel(application) {
    private val repository = PersonRepository.getInstance(application)
    fun insertEvent(event: Event) {
        viewModelScope.launch{repository?.insertEvent(event)}
    }

}