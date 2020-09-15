package com.example.multipletablists.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.multipletablists.R
import com.example.multipletablists.data.Gadgets
import kotlinx.android.synthetic.main.list_layout.view.*

class AdapterItems(private var mContext: Context, private var mList: ArrayList<Gadgets>) :
    BaseAdapter() {

    override fun getCount(): Int {
        return mList.size
    }

    override fun getItem(position: Int): Any {
        return mList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

        // Fill in list_layout.xml's components
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var view = LayoutInflater.from(mContext).inflate(R.layout.list_layout, parent, false)

        var items = mList.get(position)

        view.list_title.text = items.name
        view.list_description.text = items.description
        view.list_price.text = items.price.toString()
        view.list_available.text = items.available.toString()
        view.list_image.setImageResource(items.image)

        return view
    }


}