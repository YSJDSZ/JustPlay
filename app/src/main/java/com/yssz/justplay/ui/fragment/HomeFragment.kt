package com.yssz.justplay.ui.fragment

import com.yssz.justplay.R
import com.yssz.justplay.ui.base.BaseFragment

class HomeFragment : BaseFragment() {

    companion object {
        fun getInstance(): HomeFragment = HomeFragment()
    }

    override fun layoutRes() = R.layout.fragment_home



}