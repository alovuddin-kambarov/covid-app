package uz.coder.hilt.ui.statistic

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import uz.coder.hilt.R
import uz.coder.hilt.adapters.pager_adapters.SliderAdapter
import uz.coder.hilt.databinding.FragmentGlobalBinding
import uz.coder.hilt.models.GlobalNews
import uz.coder.hilt.utils.MyData

class GlobalFragment : Fragment() {


    var handler = Handler(Looper.myLooper()!!)
    lateinit var binding: FragmentGlobalBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGlobalBinding.inflate(layoutInflater)

        setHandleViewPager()

        return binding.root
    }


    private fun setHandleViewPager() {


        val sliderAdapter =
            SliderAdapter(MyData.getGlobalNews(), object : SliderAdapter.OnClick {
                override fun click(movieClass: GlobalNews) {
                    findNavController().navigate(R.id.newsFragment)
                }
            })

        binding.vp.adapter = sliderAdapter

        binding.vp.clipToPadding = false
        binding.vp.clipChildren = false
        binding.vp.offscreenPageLimit = 3
        binding.vp.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER


        binding.tabIndicator.setViewPager2(binding.vp)

        val compositePageTransformer = CompositePageTransformer()

        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->

            val r = 1 - kotlin.math.abs(position)

            page.scaleY = 0.85f + r * 0.15f

        }


        binding.vp.setPageTransformer(compositePageTransformer)

        binding.vp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)

            }
        })

    }



    private var runnable =
        Runnable { binding.vp.currentItem = binding.vp.currentItem + 1 }


}