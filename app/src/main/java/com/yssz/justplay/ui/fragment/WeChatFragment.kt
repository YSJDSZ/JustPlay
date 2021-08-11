package com.yssz.justplay.ui.fragment

import com.yssz.justplay.R
import com.yssz.justplay.ui.base.BaseFragment

class WeChatFragment : BaseFragment() {

    companion object {
        fun getInstance(): WeChatFragment = WeChatFragment()
    }
    override fun layoutRes() = R.layout.fragment_home
}