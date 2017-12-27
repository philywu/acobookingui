package com.acob.booking.acobookingui

import android.content.ContentValues
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acob.booking.acobookingui.model.OBEvent
import kotlinx.android.synthetic.main.eventlist_layout.view.*

/**
 * Created by wugang00 on 27/12/2017.
 */
class EventListAdapter( var lists: List<OBEvent>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var v = LayoutInflater.from(parent?.context).inflate(R.layout.eventlist_layout, parent, false)
        return Item(v)

    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var item = holder as Item
        var itemListener = View.OnClickListener {
            Log.d(ContentValues.TAG, "come on " +" pos : " + item.itemView.list_event_id.text)
            item.itemView.bar_event_item.visibility = if ( item.itemView.bar_event_item.visibility == View.GONE) View.VISIBLE else View.GONE

        }
        item.bindData(lists[position])
        item.itemView.list_event_name.setOnClickListener (itemListener)
        item.itemView.list_event_desc.setOnClickListener (itemListener)

        item.itemView.btn_event_register.setOnClickListener (
                {
                   // eventsViewEvent.eventRegister(item.itemView.list_event_id.text.toString())
                }
        )
        item.itemView.btn_event_delete.setOnClickListener (
                {
                    //eventsViewEvent.eventDelete(item.itemView.list_event_id.text.toString())
                }
        )


    }


    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(event: OBEvent) {
            itemView.list_event_id.text = event.evtId
            itemView.list_event_name.text = event.name
            itemView.list_event_desc.text = event.description
            itemView.list_event_owner.text = event.owner
            itemView.list_event_deadline.text = "Start: " + event.startTime?.asString("dd.MM HH:mm")
            itemView.list_event_start_dt.text = "Deadline: " + event.deadline?.asString("dd.MM HH:mm")

        }
    }



}