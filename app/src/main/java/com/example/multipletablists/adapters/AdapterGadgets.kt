package com.example.multipletablists.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipletablists.R
import com.example.multipletablists.data.Gadgets
import kotlinx.android.synthetic.main.list_layout.view.*

class AdapterGadgets(private var mContext: Context, private var mList: ArrayList<Gadgets>) :
    RecyclerView.Adapter<AdapterGadgets.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.list_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var gadgets = mList[position]
        holder.bind(gadgets)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(gadgets: Gadgets){
            itemView.list_title.text = gadgets.name
            itemView.list_price.text = gadgets.price.toString()
            itemView.list_available.text = gadgets.available.toString()
            itemView.list_image.setImageResource(gadgets.image)
        }
    }

}