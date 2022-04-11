package uz.coder.hilt.ui.statistic

import android.graphics.Color
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
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import uz.coder.hilt.R
import uz.coder.hilt.adapters.pager_adapters.SliderAdapter
import uz.coder.hilt.databinding.FragmentCountryBinding
import uz.coder.hilt.models.GlobalNews
import uz.coder.hilt.utils.MyData

class CountryFragment : Fragment() {

    //val mFillColor = Color.argb(150, 51, 181, 229)
    var handler = Handler(Looper.myLooper()!!)
    lateinit var binding: FragmentCountryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountryBinding.inflate(layoutInflater)


        setHandleViewPager()

        binding.apply {
            graph1.setBackgroundColor(Color.WHITE)
            graph1.setGridBackgroundColor(Color.CYAN)
            graph1.setDrawGridBackground(false)

            graph1.setDrawBorders(false)
            graph1.description.isEnabled = false
            graph1.setAddStatesFromChildren(false)
            graph1.setDrawMarkers(false)
            graph1.setDrawGridBackground(false)
            graph1.setPinchZoom(false)
        }

        setData(100, 50)
        setData(80, 90)

        return binding.root
    }

    private fun setData(count: Int, range: Int) {
        val arrayList = ArrayList<Entry>()

        for (i in 0..count) {
            val a = (Math.random() * range) + 150
            arrayList.add(Entry(i.toFloat(), a.toFloat()))
        }


        val arrayList2 = ArrayList<Entry>()

        for (i in 0..count) {
            val a = (Math.random() + range) + 250
            arrayList2.add(Entry(i.toFloat(), a.toFloat()))
        }

        val arrayList3 = ArrayList<Entry>()

        for (i in 0..count) {
            val a = (Math.random() * range) + 50
            arrayList3.add(Entry(i.toFloat(), a.toFloat()))
        }


        val lineDataSet = LineDataSet(arrayList, "Active")
        lineDataSet.axisDependency = YAxis.AxisDependency.LEFT
        lineDataSet.color = Color.BLUE
        lineDataSet.setDrawCircles(false)
        lineDataSet.lineWidth = 3f
        lineDataSet.fillAlpha = 255
        lineDataSet.disableDashedLine()
        lineDataSet.setDrawValues(false)
        lineDataSet.fillColor = Color.BLUE

        val lineDataSet2 = LineDataSet(arrayList2, "Recovered")
        lineDataSet2.axisDependency = YAxis.AxisDependency.LEFT
        lineDataSet2.color = Color.GREEN
        lineDataSet2.setDrawCircles(false)
        lineDataSet2.lineWidth = 3f
        lineDataSet2.disableDashedLine()
        lineDataSet2.fillAlpha = 255
        lineDataSet2.setDrawFilled(false)
        lineDataSet2.fillColor = Color.GREEN

        val lineDataSet3 = LineDataSet(arrayList3, "Death")
        lineDataSet3.axisDependency = YAxis.AxisDependency.LEFT
        lineDataSet3.color = Color.RED
        lineDataSet3.setDrawCircles(false)
        lineDataSet3.lineWidth = 3f
        lineDataSet3.disableDashedLine()
        lineDataSet3.fillAlpha = 155
        lineDataSet3.setDrawFilled(false)
        lineDataSet3.fillColor = Color.GREEN

        val lineData = LineData(lineDataSet, lineDataSet2, lineDataSet3)
        lineData.setDrawValues(false)


        binding.graph1.data = lineData

    }

    private fun setHandleViewPager() {


        val sliderAdapter =
            SliderAdapter(MyData.getCountryNews(), object : SliderAdapter.OnClick {
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

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

}