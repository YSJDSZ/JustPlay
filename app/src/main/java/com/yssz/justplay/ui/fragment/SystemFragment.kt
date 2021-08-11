package com.yssz.justplay.ui.fragment

import com.yssz.justplay.R
import com.yssz.justplay.ui.base.BaseFragment

class SystemFragment : BaseFragment() {

    companion object {
        fun getInstance(): SystemFragment = SystemFragment()
    }
    override fun layoutRes() = R.layout.fragment_home
}