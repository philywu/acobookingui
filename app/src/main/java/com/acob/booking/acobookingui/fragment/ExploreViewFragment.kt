package com.acob.booking.acobookingui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.acob.booking.acobookingui.R


/**
 * Created by wugang00 on 27/12/2017.
 */


class ExploreViewFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                     savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

}// Required empty public constructor