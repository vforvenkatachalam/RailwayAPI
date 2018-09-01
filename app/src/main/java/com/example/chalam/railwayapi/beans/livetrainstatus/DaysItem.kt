package com.example.chalam.railwayapi.beans.pnrstatus.livetrainstatus

import com.google.gson.annotations.SerializedName

data class DaysItem(@SerializedName("code")
                    val code: String = "",
                    @SerializedName("runs")
                    val runs: String = "")