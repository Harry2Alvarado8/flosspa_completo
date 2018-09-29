package com.etyalab.flosspa.FarmerDetail

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etyalab.flosspa.Models.Farmer
import com.etyalab.flosspa.Models.Product
import com.etyalab.flosspa.Network.imageUrl
import com.etyalab.flosspa.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsAdapter(private val productsFeed: Farmer): RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return productsFeed.farmer.product.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productsFeed.farmer)
    }

    inner class ProductViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        @SuppressLint("SetTextI18n")
        fun bind(product: Product){
            itemView.productName.text = product.product[adapterPosition].catalogName
            Picasso.get().load(imageUrl + product.product[adapterPosition].photoUrl).into(itemView.productImage)
            itemView.productPrice.text = "$${product.product[adapterPosition].retailPrice} ${product.product[adapterPosition].retailUnit}"
        }
    }
}