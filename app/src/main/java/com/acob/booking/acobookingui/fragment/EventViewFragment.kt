package com.acob.booking.acobookingui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.acob.booking.acobookingui.EventListAdapter
import com.acob.booking.acobookingui.R
import com.acob.booking.acobookingui.dateNow
import com.acob.booking.acobookingui.model.OBEvent
import kotlinx.android.synthetic.main.fragment_event.*
import kotlinx.android.synthetic.main.fragment_event.view.*
import java.util.*


/**
 * Created by wugang00 on 27/12/2017.
 */


class EventViewFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        var view =  inflater.inflate(R.layout.fragment_event, container, false)

        view.event_list

        view.event_list.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        view.event_list.hasFixedSize()
        view.event_list.adapter = EventListAdapter(getEvents())
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

    }

    fun getEvents():List<OBEvent> {
        var current = Date()
        var list = ArrayList<OBEvent>()
        var evt = OBEvent("0001","Christmas Hotpot Lunch","Christmas Hotpot Lunch",current,current,current,"Mason","New",current )
        list.add(evt)
        var evt1 = evt.copy("0002","Sunday Soccer","Sunday Soccer")
        list.add(evt1)
        return list
    }

}// Required empty public constructor