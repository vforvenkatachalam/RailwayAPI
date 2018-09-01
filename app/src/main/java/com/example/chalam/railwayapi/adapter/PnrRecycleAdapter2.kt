package com.example.chalam.railwayapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.chalam.railwayapi.R
import com.example.chalam.railwayapi.beans.pnrstatus.PNRStatusAPI
import kotlinx.android.synthetic.main.indiv_view.view.*
import kotlinx.android.synthetic.main.indiv_view2.view.*

class PnrRecycleAdapter2:RecyclerView.Adapter<MyHolder2> {
    var context:Context? = null
    var pnrBean:PNRStatusAPI? = null
    var list_sno:MutableList<String>?= mutableListOf()
    var list_booking_status:MutableList<String>?= mutableListOf()
    var list_current_status:MutableList<String>?= mutableListOf()

    constructor(pnrBean:PNRStatusAPI,context:Context)
    {
        this.context = context
        this.pnrBean = pnrBean
        Log.e("pnr bean : ",pnrBean.pnr+"\n"+pnrBean.passengers)
        for(x in pnrBean.passengers!!)
        {
            list_sno!!.add(x.no.toString())
            list_booking_status!!.add(x.bookingStatus)
            list_current_status!!.add(x.currentStatus)
        }
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder2 {
        var layoutInflater:LayoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.indiv_view2,p0,false)
        return MyHolder2(view)
    }

    override fun getItemCount(): Int {
        return pnrBean!!.passengers!!.size
    }

    override fun onBindViewHolder(p0: MyHolder2, p1: Int) {
        p0.pnr_sno!!.text = list_sno!![p1]
        p0.pnr_booking_status!!.text = list_booking_status!![p1]
        p0.pnr_current_status!!.text = list_booking_status!![p1]
    }
}
class MyHolder2:RecyclerView.ViewHolder {

    var pnr_sno: TextView? = null
    var pnr_booking_status: TextView? = null
    var pnr_current_status: TextView? = null

    constructor(v:View) : super(v)
    {
        pnr_sno = v.pnr_sno
        pnr_booking_status = v.pnr_booking_status
        pnr_current_status = v.pnr_current_status
    }
}