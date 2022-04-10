package uz.coder.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import uz.coder.hilt.R

class HelpFragment : Fragment(R.layout.fragment_help) {

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Help"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_navigation_icon)
    }

}