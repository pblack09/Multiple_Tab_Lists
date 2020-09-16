package com.example.multipletablists.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.multipletablists.R
import com.example.multipletablists.adapters.AdapterFragment
import com.example.multipletablists.adapters.AdapterGadgets
import com.example.multipletablists.data.Gadgets
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        var myAdapter = AdapterFragment(supportFragmentManager)

        myAdapter.addFragment("Mobile")
        myAdapter.addFragment("Laptop")
        myAdapter.addFragment("Desktop")

        view_pager.adapter = myAdapter

        tab_layout.setupWithViewPager(view_pager)

        tab_layout.getTabAt(0)?.setIcon(R.drawable.ic_baseline_phone_android_24)
        tab_layout.getTabAt(1)?.setIcon(R.drawable.ic_baseline_laptop_24)
        tab_layout.getTabAt(2)?.setIcon(R.drawable.ic_baseline_desktop_windows_24)
    }

}