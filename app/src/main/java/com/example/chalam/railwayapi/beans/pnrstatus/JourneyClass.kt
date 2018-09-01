package com.example.chalam.railwayapi.beans.pnrstatus

import com.google.gson.annotations.SerializedName

data class JourneyClass(@SerializedName("code")
                        val code: String = "",
                        @SerializedName("name")
                        val name: String = "")