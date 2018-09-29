package com.etyalab.flosspa.FarmerDetail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etyalab.flosspa.Models.Farmer
import com.etyalab.flosspa.Models.Farmers
import com.etyalab.flosspa.Network.imageUrl
import com.etyalab.flosspa.R
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_farmer_detail.*
import kotlinx.android.synthetic.main.fragment_farmers.*
import okhttp3.*
import java.io.IOException

class FarmerDetailFragment: Fragment() {

    lateinit var id: String

    companion object {
        fun newInstance(farmer: Farmers): FarmerDetailFragment {
            val f = FarmerDetailFragment()
            val args = Bundle()
            args.putString("id", farmer.id)
            args.putString("photo_url", farmer.imageUrl)
            args.putString("name", farmer.name)
            args.putString("email", farmer.email)
            f.arguments = args
            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_farmer_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        productsRecyclerView.layoutManager = LinearLayoutManager(activity)
        id = arguments?.get("id").toString()
        farmerName.text = arguments?.get("name").toString()
        farmerEmail.text = arguments?.get("email").toString()
        Picasso.get().load(imageUrl + arguments?.get("photo_url")).into(farmerImage)
        fetchProductsJson()
    }

    private fun fetchProductsJson(){
        val url = "https://api.mercaditoapp.com/api/v9/farmers/$id"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val enums = gson.fromJson(body, Farmer::class.java)
                activity?.runOnUiThread {
                    productsRecyclerView.adapter = ProductsAdapter(enums)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed request")
            }
        })
    }
}