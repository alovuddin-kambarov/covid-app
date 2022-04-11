package uz.coder.hilt.ui.statistic

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import uz.coder.hilt.R
import uz.coder.hilt.adapters.pager_adapters.StatisticViewPager
import uz.coder.hilt.databinding.FragmentStatisticBinding

class StatisticFragment : Fragment(R.layout.fragment_statistic) {

    private val binding: FragmentStatisticBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.vp.adapter = StatisticViewPager(this)
        val tabTitleList = ArrayList<String>()
        tabTitleList.add("Uzbekistan")
        tabTitleList.add("Global")
        TabLayoutMediator(binding.tabLayout, binding.vp) { tab, pos ->
            tab.text = tabTitleList[pos]
        }.attach()

        binding.vp.isUserInputEnabled = false

    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_navigation_icon)
    }





}