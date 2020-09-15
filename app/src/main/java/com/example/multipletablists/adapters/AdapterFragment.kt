package com.example.multipletablists.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.multipletablists.fragments.CommonFragment

class AdapterFragment(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var mFragmentList: ArrayList<Fragment> = ArrayList()
    var mTitleList: ArrayList<String> = ArrayList()

    // Return Given Fragment
    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    fun addFragment(itemName: String) {
        mFragmentList.add(CommonFragment.newInstance(itemName))
        mTitleList.add(itemName)
    }

    // Return # of Fragments
    override fun getCount(): Int {
        return mFragmentList.size
    }

    // Get titles of each data set
    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList.get(position)
    }

}