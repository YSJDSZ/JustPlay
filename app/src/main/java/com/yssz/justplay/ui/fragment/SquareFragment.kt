package com.yssz.justplay.ui.fragment

import com.yssz.justplay.R
import com.yssz.justplay.ui.base.BaseFragment


class SquareFragment : BaseFragment() {

    companion object {
        fun getInstance(): SquareFragment = SquareFragment()
    }
    override fun layoutRes() = R.layout.fragment_home
}