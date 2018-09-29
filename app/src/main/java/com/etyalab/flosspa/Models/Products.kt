package com.etyalab.flosspa.Models

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.bind.ArrayTypeAdapter

data class Farmer(
        @SerializedName("farmer")
        val farmer: Product
)

data class Product(
        @SerializedName("products")
        val product: ArrayList<Products>
)

data class Products(
        @SerializedName("id")
        val id: String,
        @SerializedName("wholesale_price")
        val wholeSalePrice: String,
        @SerializedName("wholesale_unit")
        val wholeSaleUnit: String,
        @SerializedName("retail_price")
        val retailPrice: String,
        @SerializedName("retail_unit")
        val retailUnit: String,
        @SerializedName("catalog_name")
        val catalogName: String,
        @SerializedName("photo_url")
        val photoUrl: String
)