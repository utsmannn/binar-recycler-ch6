package com.binar.latihanrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val rvPeople: RecyclerView by lazy {
        findViewById(R.id.rv_people)
    }

    private val btnAddPeople: Button by lazy {
        findViewById(R.id.btn_add_people)
    }

    private val peopleAdapter: PeopleAdapter by lazy {
        PeopleAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPeople.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvPeople.adapter = peopleAdapter

        val dataPeople = Constant.peoples
        peopleAdapter.addPeoples(dataPeople)

        btnAddPeople.setOnClickListener {
            peopleAdapter.addPeople(Constant.budi)
            peopleAdapter.addPeople(Constant.ayu)
            peopleAdapter.addPeople(Constant.agus)
        }
    }
}