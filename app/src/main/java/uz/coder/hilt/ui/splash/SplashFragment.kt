package uz.coder.hilt.ui.splash

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import uz.coder.hilt.R
import uz.coder.hilt.databinding.FragmentSplashBinding

class SplashFragment(private var pos: Int) :
    Fragment(R.layout.fragment_splash) {
    private val binding: FragmentSplashBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val arrayList = arrayListOf("Wear a Mask", "Hand Wash & Sanitize", "Pyshical Distancing")

        val arrayList1 =
            arrayListOf(R.drawable.ic_splash1, R.drawable.ic_splash2, R.drawable.ic_splash3)

        binding.tv1.text = arrayList[pos]
        binding.image.setImageResource(arrayList1[pos])

    }


}