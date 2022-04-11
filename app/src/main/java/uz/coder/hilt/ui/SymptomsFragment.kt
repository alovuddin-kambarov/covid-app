package uz.coder.hilt.ui

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import uz.coder.hilt.R
class SymptomsFragment : Fragment(R.layout.fragment_symptoms) {

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_navigation_icon)
    }

}