package uz.coder.hilt.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import uz.coder.hilt.R
import uz.coder.hilt.databinding.ActivitySplashBinding
import uz.coder.hilt.adapters.pager_adapters.SplashViewPagerAdapter
import uz.coder.hilt.ui.MainActivity
import uz.coder.hilt.utils.MySharedPreference

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val binding: ActivitySplashBinding by viewBinding()
    var a = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        binding.vp.adapter = SplashViewPagerAdapter(supportFragmentManager)
        binding.tabIndicator.setViewPager(binding.vp)

        binding.vp.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                a = position
                val arrayList2 = arrayListOf("GET STARTED", "NEXT", "NEXT")
                binding.tv3.text = arrayList2[position]

            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        binding.card.setOnClickListener {
            binding.vp.currentItem++
            if (a == 2){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        }

        isLogIn()

    }

    private fun isLogIn(){
        MySharedPreference.getInstance(this)
        if (MySharedPreference.isLogIn!!){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

}