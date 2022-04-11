package uz.coder.hilt.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import uz.coder.hilt.R
import uz.coder.hilt.databinding.FragmentPreventionBinding
import uz.coder.hilt.adapters.rv_adapters.PreventionAllAdapter
import uz.coder.hilt.models.Prevention
import uz.coder.hilt.utils.MyData

class PreventionFragment : Fragment(R.layout.fragment_prevention) {

    private val binding: FragmentPreventionBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rv.adapter = PreventionAllAdapter(MyData.getPreventionData(), object :
            PreventionAllAdapter.OnItemClick {
            override fun click(prevention: Prevention) {
                startActivity(
                    Intent(
                        binding.root.context,
                        AboutActivity::class.java
                    ).putExtra("prevention", prevention).putExtra("key", true)
                )
            }
        })

    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_navigation_icon)
    }

}