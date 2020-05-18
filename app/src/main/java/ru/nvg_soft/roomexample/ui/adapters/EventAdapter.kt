package ru.nvg_soft.roomexample.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_event.view.*
import ru.nvg_soft.roomexample.R
import ru.nvg_soft.roomexample.data.Event

class EventAdapter():RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    var items:List<Event> = listOf()
    inner class EventViewHolder(convertView: View) : RecyclerView.ViewHolder(convertView) {


        fun bind(event: Event) {
            itemView.tv_event_name.text = event.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.item_event,parent,false)
        return EventViewHolder(convertView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) =holder.bind(items[position])

    fun updateData(data: List<Event>){
        val diffCallback = object: DiffUtil.Callback(){
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                items[oldItemPosition].id == data[newItemPosition].id

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