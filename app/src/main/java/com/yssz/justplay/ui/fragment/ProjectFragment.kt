package com.yssz.justplay.ui.fragment

import com.yssz.justplay.R
import com.yssz.justplay.ui.base.BaseFragment

class ProjectFragment : BaseFragment() {

    companion object {
        fun getInstance(): ProjectFragment = ProjectFragment()
    }
    override fun layoutRes() = R.layout.fragment_home
}