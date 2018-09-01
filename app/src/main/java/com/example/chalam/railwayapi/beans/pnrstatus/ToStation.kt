package com.example.chalam.railwayapi.beans.pnrstatus

import com.google.gson.annotations.SerializedName

data class ToStation(@SerializedName("code")
                     val code: String = "",
                     @SerializedName("lng")
                     val lng: Double = 0.0,
                     @SerializedName("name")
                     val name: String = "",
                     @SerializedName("lat")
                     val lat: Double = 0.0)