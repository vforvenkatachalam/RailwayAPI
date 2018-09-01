package com.example.chalam.railwayapi.Interfaces

import com.example.chalam.railwayapi.beans.pnrstatus.PNRStatusAPI
import com.example.chalam.railwayapi.beans.pnrstatus.livetrainstatus.LiveTrainStatus
import com.example.chalam.railwayapi.beans.trainroute.TrainRouteBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RailwayAPI {
    @GET("pnr-status/pnr/{pnr}/apikey/xbrahz52gl/")
    fun getPnrStatus(@Path("pnr")pnrno:String):Call<PNRStatusAPI>

    @GET("https://api.railwayapi.com/v2/live/train/{trainname}/date/{traveldate}/apikey/xbrahz52gl/")
    fun getLiveTrainStatus(@Path("trainname")trainname:String,
                           @Path("traveldate")traveldate:String):Call<LiveTrainStatus>

    @GET("route/train/{trainnumber}/apikey/xbrahz52gl/")
    fun trainRoute(@Path("trainnumber")trainnumber:String):Call<TrainRouteBean>
}