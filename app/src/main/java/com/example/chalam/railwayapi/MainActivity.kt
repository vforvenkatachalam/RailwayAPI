package com.example.chalam.railwayapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout:DrawerLayout
    lateinit var mToggle:ActionBarDrawerToggle
    lateinit var navigationView:NavigationView
    lateinit var textView:TextView
    var fmanager: FragmentManager? = supportFragmentManager
    var frag0 = Home()
    var frag1 = LiveTrainStatus()
    var frag2 = PnrStatus()
    var frag3 = TrainRoute()
    var frag4 = SeatAvailability()
    var frag5 = TrainBetweenStations()
    var frag6 = TrainNameorNumber()
    var frag7 = TrainFareEnquiry()
    var frag8 = TrainArrivals()
    var frag9 = CancelledTrains()
    var frag10 = RescheduledTrains()
    var frag11 = StationNameToCode()
    var frag12 = StationCodeToName()
    var frag13 = StationAutocompleteSuggest()
    var frag14 = TrainAutoCompleteSuggest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        mToggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)

        drawerLayout.addDrawerListener(mToggle)
        mToggle.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        textView = findViewById(R.id.textView)
        navigationView = findViewById(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this)

        var tx:FragmentTransaction = fmanager!!.beginTransaction()
        tx.add(R.id.frag,frag0) //Home
        tx.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(mToggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        drawerLayout.closeDrawers()
        var id:Int = p0.itemId

        if(id == R.id.home)
        {
            var tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag0)
            tx.commit()
        }

        if(id == R.id.livetrainstatus)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag1) //live train status
            tx!!.commit()
        }

        if(id == R.id.pnrstatus)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag2)
            tx!!.commit()
        }

        if(id == R.id.trainroute)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag3)
            tx!!.commit()
        }

        if(id == R.id.seatavailability)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag4)
            tx!!.commit()
        }

        if(id == R.id.trainbetweenstations)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag5)
            tx!!.commit()
        }

        if(id == R.id.trainnameornumber)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag6)
            tx!!.commit()
        }

        if(id == R.id.trainfareenquiry)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag7)
            tx!!.commit()
        }

        if(id == R.id.trainarivals)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag8)
            tx!!.commit()
        }

        if(id == R.id.cancelledtrains)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag9)
            tx!!.commit()
        }

        if(id == R.id.rescheduledtrains)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag10)
            tx!!.commit()
        }

        if(id == R.id.stationnametocode)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag11)
            tx!!.commit()
        }

        if(id == R.id.stationcodetoname)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag12)
            tx!!.commit()
        }

        if(id == R.id.stationautocompletesuggest)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag13)
            tx!!.commit()
        }

        if(id == R.id.trainautocompletesuggest)
        {
            val tx:FragmentTransaction = fmanager!!.beginTransaction()
            tx.replace(R.id.frag,frag14)
            tx!!.commit()
        }
        return true
    }
}