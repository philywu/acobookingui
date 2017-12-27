package com.acob.booking.acobookingui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.acob.booking.acobookingui.fragment.ChannelViewFragment
import com.acob.booking.acobookingui.fragment.ContactViewFragment
import com.acob.booking.acobookingui.fragment.EventViewFragment
import com.acob.booking.acobookingui.fragment.ExploreViewFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.channels.Channel

class MainActivity : AppCompatActivity() {

    var prevMenuItem: MenuItem? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_event -> {
                //message.setText(R.string.title_event)
                viewpager.setCurrentItem(0)
                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_channel -> {
               // message.setText(R.string.title_channel)
                viewpager.setCurrentItem(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_explore -> {
                viewpager.setCurrentItem(2)
              //  message.setText(R.string.title_explore)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_contact -> {
                viewpager.setCurrentItem(3)
              //  message.setText(R.string.title_contact)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tool_bar as Toolbar?)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem!!.setChecked(false)
                } else {
                    bottom_navigation.getMenu().getItem(0).setChecked(false)
                }
                Log.d("page", "onPageSelected: " + position)
                bottom_navigation.getMenu().getItem(position).setChecked(true)
                prevMenuItem = bottom_navigation.getMenu().getItem(position)

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        setupViewPager(viewpager);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    fun setupViewPager( viewPager: ViewPager)
    {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(EventViewFragment())
        adapter.addFragment(ChannelViewFragment())
        adapter.addFragment(ExploreViewFragment())
        adapter.addFragment(ContactViewFragment())
        viewPager.adapter = adapter
    }

}
