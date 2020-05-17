package ru.nvg_soft.roomexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.nvg_soft.roomexample.data.Person
import ru.nvg_soft.roomexample.repositories.PersonRepository

class AddPersonViewModel(application: Application):AndroidViewModel(application) {
    private val repository = PersonRepository.getInstance(application)

    fun insertPerson(person: Person) {
        viewModelScope.launch{repository?.insert(person)}
    }

}