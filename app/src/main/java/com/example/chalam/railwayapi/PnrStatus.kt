package com.example.chalam.railwayapi

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.chalam.railwayapi.Interfaces.RailwayAPI
import com.example.chalam.railwayapi.adapter.PnrRecycleAdapter
import com.example.chalam.railwayapi.beans.pnrstatus.PNRStatusAPI
import kotlinx.android.synthetic.main.pnrstatus.*
import kotlinx.android.synthetic.main.pnrstatus.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PnrStatus:Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.pnrstatus,container,false)

        var r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://api.railwayapi.com/v2/").build()
        var api = r.create(RailwayAPI::class.java)


        view.recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        view.recyclerView.setHasFixedSize(true)
        /*view.recyclerView2.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        view.recyclerView2.setHasFixedSize(true)*/

        var button = view.findViewById<Button>(R.id.getstatus)
        button.setOnClickListener({

            var cal = api.getPnrStatus(pnrnumber.text.toString())
            cal.enqueue(object : Callback<PNRStatusAPI> {
                override fun onResponse(call: Call<PNRStatusAPI>?, response: Response<PNRStatusAPI>?)
                {
                    var pnrbean = response!!.body()
                    if(pnrbean!!.pnr != view.pnrnumber.text.toString()){
                        view.pnrnumber.text = null
                        Toast.makeText(context,"Enter valid PNR or not yet Generated",Toast.LENGTH_LONG).show()
                    }else {
                        recyclerView.adapter = PnrRecycleAdapter(pnrbean!!, context!!)
                        //recyclerView2.adapter = PnrRecycleAdapter2(pnrbean!!, context!!)
                    }
                }
                override fun onFailure(call: Call<PNRStatusAPI>?, t: Throwable?) {
                    Toast.makeText(activity,"Failure",Toast.LENGTH_LONG).show()
                }
            })
        })

        return view
    }
}