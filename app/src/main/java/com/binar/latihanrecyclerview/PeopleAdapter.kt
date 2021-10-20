package com.binar.latihanrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {
    private val peoples: MutableList<People> = mutableListOf()

    fun addPeoples(peoples: List<People>) {
        this.peoples.addAll(peoples)
        notifyDataSetChanged()
    }

    fun addPeople(people: People) {
        this.peoples.add(people)
        notifyDataSetChanged()
    }

    inner class PeopleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(itemPeople: People) = itemView.run {
            val tvItemName: TextView = findViewById(R.id.item_tv_name)
            val tvItemAge: TextView = findViewById(R.id.item_tv_age)
            val tvItemGender: TextView = findViewById(R.id.item_tv_gender)

            tvItemName.text = itemPeople.name
            tvItemAge.text = itemPeople.age.toString()
            tvItemGender.text = itemPeople.gender
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_people, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people = peoples[position]
        holder.bind(people)
    }

    override fun getItemCount(): Int {
        return peoples.size
    }
}