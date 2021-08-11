package com.yssz.justplay.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yssz.justplay.ui.fragment.HomeFragment
import com.yssz.justplay.ui.fragment.SquareFragment
import com.yssz.justplay.R
import com.yssz.justplay.ui.fragment.ProjectFragment
import com.yssz.justplay.ui.fragment.SystemFragment
import com.yssz.justplay.ui.fragment.WeChatFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private val FRAGMENT_HOME = 0x01
    private val FRAGMENT_SQUARE = 0x02
    private val FRAGMENT_WECHAT = 0x03
    private val FRAGMENT_SYSTEM = 0x04
    private val FRAGMENT_PROJECT = 0x05

    private var mIndex = FRAGMENT_HOME

    private var mHomeFragment: HomeFragment? = null
    private var mSquareFragment: SquareFragment? = null
    private var mWeChatFragment: WeChatFragment? = null
    private var mSystemFragment: SystemFragment? = null
    private var mProjectFragment: ProjectFragment? = null

    companion object{
        fun actionStart(context: Context){
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        showFragment(mIndex)
        initDrawerLayout()

    }



    private fun initView() {
        setSupportActionBar(toolbar)
        //导航按钮显示出来
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
        }
        bottom_navigation.run {
            setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        }
    }
    private val onNavigationItemSelectedListener =BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.action_home -> {
                showFragment(FRAGMENT_HOME)
                true
            }
            R.id.action_square -> {
                showFragment(FRAGMENT_SQUARE)
                true
            }
            R.id.action_system -> {
                showFragment(FRAGMENT_SYSTEM)
                true
            }
            R.id.action_project -> {
                showFragment(FRAGMENT_PROJECT)
                true
            }
            R.id.action_wechat -> {
                showFragment(FRAGMENT_WECHAT)
                true
            }
            else -> {
                false
            }

        }
    }
    /**
     * 展示Fragment
     * @param index
     */
    private fun showFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideFragments(transaction)
        mIndex = index
        when (index) {
            FRAGMENT_HOME // 首页
            -> {
                toolbar.title = getString(R.string.app_name)
                if (mHomeFragment == null) {
                    mHomeFragment = HomeFragment.getInstance()
                    transaction.add(R.id.container, mHomeFragment!!, "home")
                } else {
                    transaction.show(mHomeFragment!!)
                }
            }
            FRAGMENT_SQUARE  // 广场
            -> {
                toolbar.title = getString(R.string.square)
                if (mSquareFragment == null) {
                    mSquareFragment = SquareFragment.getInstance()
                    transaction.add(R.id.container, mSquareFragment!!, "square")
                } else {
                    transaction.show(mSquareFragment!!)
                }
            }
            FRAGMENT_SYSTEM // 体系
            -> {
                toolbar.title = getString(R.string.knowledge_system)
                if (mSystemFragment == null) {
                    mSystemFragment = SystemFragment.getInstance()
                    transaction.add(R.id.container, mSystemFragment!!, "system")
                } else {
                    transaction.show(mSystemFragment!!)
                }
            }
            FRAGMENT_PROJECT // 项目
            -> {
                toolbar.title = getString(R.string.project)
                if (mProjectFragment == null) {
                    mProjectFragment = ProjectFragment.getInstance()
                    transaction.add(R.id.container, mProjectFragment!!, "project")
                } else {
                    transaction.show(mProjectFragment!!)
                }
            }
            FRAGMENT_WECHAT // 公众号
            -> {
                toolbar.title = getString(R.string.wechat)
                if (mWeChatFragment == null) {
                    mWeChatFragment = WeChatFragment.getInstance()
                    transaction.add(R.id.container, mWeChatFragment!!, "wechat")
                } else {
                    transaction.show(mWeChatFragment!!)
                }
            }
        }
        transaction.commit()
    }

    /**
     * 隐藏掉所有的Fragment
     */
    private fun hideFragments(transaction: FragmentTransaction) {
        mHomeFragment?.let { transaction.hide(it) }
        mSquareFragment?.let { transaction.hide(it) }
        mSystemFragment?.let { transaction.hide(it) }
        mProjectFragment?.let { transaction.hide(it) }
        mWeChatFragment?.let { transaction.hide(it) }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> drawer_layout.openDrawer(GravityCompat.START)
        }
        return true
    }
    private fun initDrawerLayout() {
        drawer_layout.run {
            val toggle = ActionBarDrawerToggle(
                this@MainActivity,
                this,
                toolbar
                , R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
            addDrawerListener(toggle)
            toggle.syncState()
    }}
}