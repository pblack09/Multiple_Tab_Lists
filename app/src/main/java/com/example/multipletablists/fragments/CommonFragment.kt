package com.example.multipletablists.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multipletablists.R
import com.example.multipletablists.adapters.AdapterFragment
import com.example.multipletablists.adapters.AdapterItems
import com.example.multipletablists.data.Gadgets
import kotlinx.android.synthetic.main.fragment_common.view.*

private const val ARG_PARAM1 = "param1"

class CommonFragment : Fragment() {

        // Lists for each Fragment
    var mList: ArrayList<Gadgets> = ArrayList()

        // Names of each Fragment
    private var itemName: String? = null

        // Take name from MainActivity and use to generate its data
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemName = it.getString(ARG_PARAM1)
        }

        generateData(itemName!!)
    }

        // Generate data for given name from MainActivity
    private fun generateData(itemName: String){
        when(itemName){
            "Mobile" -> generateMobile()
            "Laptop" -> generateLaptop()
            "Desktop" -> generateDesktop()
        }
    }

        //
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_common, container, false)

        init(view)

        return view
    }

        // Set the Fragment's <ListView> with the data
    private fun init(view: View){
        var myAdapter = AdapterItems(view.context, mList)

        view.list_view.adapter = myAdapter
    }

        // Receive parameter from MainActivity
    companion object{
        fun newInstance(itemName: String) =
            CommonFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, itemName)
                }
            }
    }

        // BELOW ARE ALL DATA GENERATORS
    private fun generateMobile(){
            mList.add(Gadgets("iPhone", 399.99,"Apple's phone compatible with Mac products", true,R.drawable.iphone))
            mList.add(Gadgets("Google Pixel", 499.99,"Google's phone that is very customizable", true,R.drawable.google_pixel))
            mList.add(Gadgets("HuaWei", 199.99,"Security risk", false,R.drawable.huawei))
            mList.add(Gadgets("Samsung S9", 449.99,"Samsung's flagship phone", true,R.drawable.samsung_s9))
            mList.add(Gadgets("My Phone", 19.99,"Sometimes refuses to cooperate", false,R.drawable.my_phone))
    }

    private fun generateLaptop(){
        mList.add(Gadgets("Apple Macbook", 1399.99,"Apple's primary laptop", true,R.drawable.macbook))
        mList.add(Gadgets("Lenovo Touch", 799.99,"Inexpensive laptop with few special features", true,R.drawable.lenovo))
        mList.add(Gadgets("Microsoft Surface", 1299.99,"User friendly laptop for students", true,R.drawable.surface))
        mList.add(Gadgets("Dell XPS", 999.99,"Cheaper and more forgiving", true,R.drawable.dell))
    }

    private fun generateDesktop(){
        mList.add(Gadgets("iMac", 2399.99,"Apple's main desktop computer", true,R.drawable.imac))
        mList.add(Gadgets("Mac Pro", 5399.99,"You can't afford this", true,R.drawable.mac_pro))
        mList.add(Gadgets("Dell Inspirion", 399.99,"Out of date", false,R.drawable.dell_desktop))
        mList.add(Gadgets("NZXT", 1199.99,"Lots of modularity for the consumer's needs", false,R.drawable.nzxt))
        mList.add(Gadgets("Alienware", 2849.99,"Expensive and high performing product", true,R.drawable.alienware))
    }

}