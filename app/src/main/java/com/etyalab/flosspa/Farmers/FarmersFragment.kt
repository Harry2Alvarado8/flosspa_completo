package com.etyalab.flosspa.Farmers

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etyalab.flosspa.Models.Farmers
import com.etyalab.flosspa.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_farmers.*
import okhttp3.*
import java.io.IOException

class FarmersFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(container?.context).inflate(R.layout.fragment_farmers, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        farmersRecyclerView.layoutManager = LinearLayoutManager(activity)
        fetchFarmersJson()
    }

    private fun fetchFarmersJson() {
        val shopUrl = "https://api.mercaditoapp.com/api/v9/farmers"
        val request = Request.Builder().url(shopUrl).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val enums = gson.fromJson(body, Array<Farmers>::class.java)
                activity!!.runOnUiThread {
                    farmersRecyclerView.adapter = FarmersAdapter(enums){ farmerClicked(it) }
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed request")
            }
        })
    }

    fun farmerClicked(farmer: Farmers){

    }
}