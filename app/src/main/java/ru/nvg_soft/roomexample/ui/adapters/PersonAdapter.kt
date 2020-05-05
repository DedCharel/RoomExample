package ru.nvg_soft.roomexample.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_person.view.*
import ru.nvg_soft.roomexample.R
import ru.nvg_soft.roomexample.data.Person

class PersonAdapter():RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    var items:List<Person> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(convertView)
    }

    override fun getItemCount(): Int= items.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) =holder.bind(items[position])

    inner class PersonViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {


        fun bind(person: Person) {
            itemView.tv_person_name.text = person.name
        }

    }

    fun updateData(data: List<Person>){
        val diffCallback = object: DiffUtil.Callback(){
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition].personId == data[newItemPosition].personId

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition].hashCode() == data[newItemPosition].hashCode()

            override fun getOldListSize(): Int = items.size

            override fun getNewListSize(): Int = data.size
        }

        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items = data
        diffResult.dispatchUpdatesTo(this)
    }

}