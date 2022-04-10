package uz.coder.hilt.ui.news

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import uz.coder.hilt.R
import uz.coder.hilt.databinding.FragmentNewsBinding
import uz.coder.hilt.adapters.pager_adapters.NewsViewPager

class NewsFragment : Fragment(R.layout.fragment_news) {

    private val binding: FragmentNewsBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabTitleList = ArrayList<String>()

        tabTitleList.add("All news")
        tabTitleList.add("Saved")

        binding.vp.adapter = NewsViewPager(this)
        TabLayoutMediator(binding.tabLayout, binding.vp) { tab, pos ->
            tab.text = tabTitleList[pos]
        }.attach()


    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "News"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_navigation_icon)
    }


}


