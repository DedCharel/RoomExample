package ru.nvg_soft.roomexample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_add_event.*
import ru.nvg_soft.roomexample.R
import ru.nvg_soft.roomexample.data.Event
import ru.nvg_soft.roomexample.viewmodel.AddEventModel

class AddEventActivity:AppCompatActivity() {
    private lateinit var viewModel:AddEventModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)
       // initView()
        initViewModel()
        btn_add_event.setOnClickListener {
            viewModel.insertEvent(Event(null,et_event_name.text.toString()))
            finish()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(AddEventModel::class.java)
    }
}