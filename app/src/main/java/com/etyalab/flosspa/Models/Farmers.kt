package com.etyalab.flosspa.Models

import com.google.gson.annotations.SerializedName

data class Farmers(
        @SerializedName("id")
        val id: String,
        @SerializedName("first_name")
        val name: String,
        @SerializedName("lats_name")
        val lastName: String,
        @SerializedName("email")
        val email: String
)