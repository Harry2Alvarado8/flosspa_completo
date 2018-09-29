package com.etyalab.flosspa.Farmers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etyalab.flosspa.Models.Farmers
import com.etyalab.flosspa.Network.imageUrl
import com.etyalab.flosspa.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_farmers.view.*

class FarmersAdapter(val farmersFeed: Array<Farmers>, private val onFarmerClicked: (Farmers) -> Unit) : RecyclerView.Adapter<FarmersAdapter.FarmersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_farmers, parent, false)
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
            itemView.lastName.text = farmers.lastName
            itemView.farmName.text = farmers.farmName
            itemView.province.text = farmers.province
            itemView.address.text = farmers.address
            itemView.setOnClickListener {
                onFarmerClicked(farmers)
            }
            if (!farmers.imageUrl.isNullOrEmpty()){
                Picasso.get().load(imageUrl + farmers.imageUrl).into(itemView.farmerImage)
            }

        }
    }
}