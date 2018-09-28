package com.etyalab.flosspa.Farmers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etyalab.flosspa.Models.Farmers
import com.etyalab.flosspa.R
import kotlinx.android.synthetic.main.item_farmers.view.*

class FarmersAdapter(val farmersFeed: Array<Farmers>, private val onFarmerClicked: (Farmers) -> Unit) : RecyclerView.Adapter<FarmersAdapter.FarmersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmersViewHolder {
        val LayoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = LayoutInflater.inflate(R.layout.item_farmers, parent, false)
        return FarmersViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return farmersFeed.size
    }

    override fun onBindViewHolder(holder: FarmersViewHolder, position: Int) {
        holder.bind(farmersFeed[position])
    }

    inner class FarmersViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bind(farmers: Farmers){
            itemView.name.text = farmers.name
            itemView.setOnClickListener {
                onFarmerClicked(farmers)
            }
        }
    }
}