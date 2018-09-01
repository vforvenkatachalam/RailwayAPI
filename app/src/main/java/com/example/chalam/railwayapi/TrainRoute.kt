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
import com.example.chalam.railwayapi.beans.trainroute.TrainRouteBean
import kotlinx.android.synthetic.main.trainroute.*
import kotlinx.android.synthetic.main.trainroute.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TrainRoute:Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view:View = inflater.inflate(R.layout.trainroute,container,false)
        var r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.railwayapi.com/v2/").build()
        var api = r.create(RailwayAPI::class.java)

        var button = view.findViewById<Button>(R.id.trainroutebutton)
        button.setOnClickListener({

            var calls = api.trainRoute(view.trainroutenumber.text.toString())
            calls.enqueue(object:Callback<TrainRouteBean>{
                override fun onFailure(call: Call<TrainRouteBean>?, t: Throwable?) {
                    Toast.makeText(activity,"Network Failure..!",Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<TrainRouteBean>?, response: Response<TrainRouteBean>?) {

                    var trainrouteresponse = response!!.body()
                    var list = mutableListOf<String>()
                    list.add("Train Name : "+trainrouteresponse!!.train.name)
                    list.add("Train Name : "+trainrouteresponse!!.train.number)
                    for(x in trainrouteresponse.route!!)
                    {
                        list.add("No : "+x.no+"\t Station Name : "+x.station.name+"\t Code : "+x.station.code+"\n Lattitude : "+x.station.lat+"\t Longitude : "+x.station.lng)
                    }

                    var myadapter = ArrayAdapter<String>(activity,android.R.layout.simple_list_item_1,list)
                    trainroute_listview.adapter = myadapter
                }

            })

        })
        return view
    }
}