package ru.nvg_soft.roomexample.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_event.*
import ru.nvg_soft.roomexample.R
import ru.nvg_soft.roomexample.ui.adapters.EventAdapter
import ru.nvg_soft.roomexample.viewmodel.EventViewModel

class EventActivity:AppCompatActivity() {
    lateinit var eventAdapter: EventAdapter
    lateinit var viewModel:EventViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)
        initView()
        initViewModel()
        btn_add_event.setOnClickListener { addEvent() }
    }

    private fun initView() {
        eventAdapter = EventAdapter()
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        with(rv_event){
            adapter = eventAdapter
            layoutManager = LinearLayoutManager(this@EventActivity)
            addItemDecoration(divider)
        }
    }

    private fun addEvent() {
        var intent = Intent(layoutInflater.context,AddEventActivity::class.java)
        layoutInflater.context.startActivity(intent)


    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(EventViewModel::class.java)
        viewModel.getEventData().observe(this, Observer { eventAdapter.updateData(it) })
    }
}