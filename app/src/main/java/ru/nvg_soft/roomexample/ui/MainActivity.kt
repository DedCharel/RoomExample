package ru.nvg_soft.roomexample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.nvg_soft.roomexample.R
import ru.nvg_soft.roomexample.ui.adapters.PersonAdapter
import ru.nvg_soft.roomexample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var personAdapter: PersonAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initViewModel()
        fab.setOnClickListener { addData() }
        btn_open_event.setOnClickListener { openEvent() }
    }

    private fun openEvent() {
        var intent =Intent(layoutInflater.context,EventActivity::class.java)
        layoutInflater.context.startActivity(intent)

    }

    private fun addData() {

         Log.d("M_MainActivity","addPerson")

        var intent =Intent(layoutInflater.context,AddPersonActivity::class.java)
            layoutInflater.context.startActivity(intent)

    }


    private fun initView() {
        personAdapter = PersonAdapter()
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        with(rv_person_list){
            adapter = personAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(divider)
        }

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getPersonData().observe(this, Observer { personAdapter.updateData(it) })
    }

}
