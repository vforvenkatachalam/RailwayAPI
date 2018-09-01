package com.example.chalam.railwayapi.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.chalam.railwayapi.R
import com.example.chalam.railwayapi.beans.pnrstatus.PNRStatusAPI
import kotlinx.android.synthetic.main.indiv_view.view.*

class PnrRecycleAdapter:RecyclerView.Adapter<MyHolder> {
    var context:Context? = null
    var pnr_from:String? = null
    var pnr_to:String? = null
    var pnr_train_numb:String? = null
    var pnr_train_name:String? = null
    var pnr_board_point:String? = null
    var pnr_psngr_no:String? = null
    var pnr_chartprep:String? = null
    var pnr_rese_upto:String? = null

    constructor(pnrbean:PNRStatusAPI,context:Context)
    {
        pnr_from = pnrbean.fromStation.name
        pnr_to = pnrbean.toStation.name
        pnr_train_numb = pnrbean.train.name
        pnr_train_name = pnrbean.train.number
        pnr_board_point = pnrbean.boardingPoint.name
        pnr_psngr_no = pnrbean.passengers!!.size.toString()
        pnr_chartprep = pnrbean.chartPrepared.toString()
        pnr_rese_upto = pnrbean.reservationUpto.name
        for(x in pnrbean.passengers)
        {

            pnrbean
        }
        this.context = context
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolder {
        var inflater:LayoutInflater = LayoutInflater.from(context)
        var view:View = inflater.inflate(R.layout.indiv_view,p0,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(p0: MyHolder, p1: Int) {
        p0.pnr_frm!!.text = pnr_from
        p0.pnr_too!!.text = pnr_to
        p0.pnr_board_point!!.text = pnr_board_point
        p0.pnr_chartprep!!.text = pnr_chartprep
        p0.pnr_psngr_no!!.text = pnr_psngr_no
        p0.pnr_rese_upto!!.text = pnr_rese_upto
        p0.pnr_train_name!!.text = pnr_train_name
        p0.pnr_train_numb!!.text = pnr_train_numb
    }
}
class MyHolder:RecyclerView.ViewHolder
{
    var pnr_too:TextView? = null
    var pnr_frm:TextView? = null
    var pnr_train_numb:TextView? = null
    var pnr_train_name:TextView? = null
    var pnr_board_point:TextView? = null
    var pnr_psngr_no:TextView? = null
    var pnr_chartprep:TextView? = null
    var pnr_rese_upto:TextView? = null

    constructor(v:View) : super(v)
    {
        pnr_frm = v.pnr_from
        pnr_too = v.pnr_to
        pnr_train_numb = v.pnr_train_number
        pnr_train_name = v.pnr_train_name
        pnr_psngr_no = v.pnr_no_of_psgr
        pnr_board_point = v.pnr_boarding
        pnr_chartprep = v.pnr_chart_prep
        pnr_rese_upto = v.pnr_reser_upto
    }
}