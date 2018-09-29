package com.etyalab.flosspa.Models

import com.google.gson.annotations.SerializedName

data class Farmers(
        @SerializedName("id")
        val id: String,
        @SerializedName("first_name")
        val name: String,
        @SerializedName("last_name")
        val lastName: String,
        @SerializedName("email")
        val email: String,
        @SerializedName("image_url")
        val imageUrl: String,
        @SerializedName("province_name")
        val province: String,
        @SerializedName("address")
        val address: String,
        @SerializedName("farm_name")
        val farmName: String
)