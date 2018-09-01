package com.example.chalam.railwayapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import com.example.chalam.railwayapi.Interfaces.RailwayAPI
import com.example.chalam.railwayapi.beans.pnrstatus.livetrainstatus.LiveTrainStatus
import kotlinx.android.synthetic.main.livetrainstatus.*
import kotlinx.android.synthetic.main.livetrainstatus.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LiveTrainStatus:Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view:View = inflater.inflate(R.layout.livetrainstatus,container,false)

        var r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.railwayapi.com/v2/").build()
        var api = r.create(RailwayAPI::class.java)

        var button = view.findViewById<Button>(R.id.livebutton)
        button.setOnClickListener({

            var call = api.getLiveTrainStatus(livetrainname.text.toString(),livedatepicker.text.toString())
            call.enqueue(object:Callback<LiveTrainStatus>{
                override fun onFailure(call: Call<LiveTrainStatus>?, t: Throwable?) {
                    Toast.makeText(activity,"Failure", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<LiveTrainStatus>?, response: Response<LiveTrainStatus>?) {
                    var livetrainstatusObject = response!!.body()
                    var list = mutableListOf<String>()
                    list.add("Current Station Name : "+livetrainstatusObject!!.currentStation.name)
                    list.add("Current Station Lattitude : "+livetrainstatusObject!!.currentStation.lat)
                    list.add("Current Station Longitude : "+livetrainstatusObject!!.currentStation.lng)
                    list.add("Position : "+livetrainstatusObject!!.position)
                    list.add("Debit : "+livetrainstatusObject!!.debit)
                    list.add("Start Date : "+livetrainstatusObject!!.startDate)
                    list.add("Train  Name : "+livetrainstatusObject!!.train.name)

                    var adapter = ArrayAdapter(activity,android.R.layout.simple_list_item_1,list)
                    view.listview.adapter = adapter
                }

            })
        })

        return view
    }
}