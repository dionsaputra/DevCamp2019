package ds.appname.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ds.appname.home.HomeFragment
import ds.appname.order.OrderFragment

class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = mutableListOf<Fragment>()

    init {
        fragments.add(HomeFragment.newInstance())
        fragments.add(OrderFragment.newInstance())
    }

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

}