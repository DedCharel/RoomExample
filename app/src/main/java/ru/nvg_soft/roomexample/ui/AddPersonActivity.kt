package ru.nvg_soft.roomexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_person.*
import ru.nvg_soft.roomexample.R
import ru.nvg_soft.roomexample.data.Person
import ru.nvg_soft.roomexample.repositories.PersonRepository
import ru.nvg_soft.roomexample.ui.adapters.PersonAdapter
import ru.nvg_soft.roomexample.viewmodel.AddPersonViewModel

class AddPersonActivity:AppCompatActivity() {
    private lateinit var viewModel: AddPersonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)
      //  initView()
        initViewModel()
        btn_add.setOnClickListener {
            viewModel.insertPerson(Person(null, et_person_name.text.toString(),
                et_DOB.text.toString().toInt(),
                et_weight.text.toString().toInt(),
                et_height.text.toString().toInt()))
            finish() }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(AddPersonViewModel::class.java)
    }

    private fun initView() {

    }
}