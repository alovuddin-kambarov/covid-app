package uz.coder.hilt.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.coder.hilt.R
import uz.coder.hilt.adapters.SpinnerAdapter
import uz.coder.hilt.adapters.rv_adapters.HomeNewsAdapter
import uz.coder.hilt.adapters.rv_adapters.PreventionAdapter
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.FragmentHomeBinding
import uz.coder.hilt.models.Prevention
import uz.coder.hilt.ui.AboutActivity
import uz.coder.hilt.utils.MyData
import uz.coder.hilt.utils.NewsResource
import uz.coder.hilt.viewmodels.NewsViewModel

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var dialog: AlertDialog
    private val myViewModel: NewsViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setProgress()

        binding.spin1.adapter = SpinnerAdapter(MyData.getCountryData())

        binding.rvPrevention.adapter =
            PreventionAdapter(MyData.getPreventionData(), object : PreventionAdapter.OnItemClick {
                override fun click(prevention: Prevention) {
                    startActivity(
                        Intent(
                            binding.root.context,
                            AboutActivity::class.java
                        ).putExtra("prevention", prevention).putExtra("key", true)
                    )
                }
            })


        myViewModel.getNewsAndArticle().observe(viewLifecycleOwner) {
            when (it) {
                is NewsResource.Error -> {
                    Toast.makeText(binding.root.context, it.message, Toast.LENGTH_SHORT).show()
                    dialog.cancel()
                }
                NewsResource.Loading -> {
                    println("alovuddin: loading...")
                }
                is NewsResource.Success -> {

                    dialog.cancel()

                    val aaa = object : HomeNewsAdapter.OnItemClick {
                        override fun click(news: NewsEntity) {

                            startActivity(
                                Intent(
                                    binding.root.context,
                                    AboutActivity::class.java
                                ).putExtra("news", news).putExtra("key", false)
                            )
                        }
                    }

                    binding.rvNews.adapter =
                        HomeNewsAdapter(it.list as ArrayList<NewsEntity>, aaa)


                    binding.rvArticle.adapter =
                        HomeNewsAdapter(it.list, aaa)


                }
            }


        }

        binding.allArticle.setOnClickListener {
            findNavController().navigate(R.id.articleFragment)
        }

        binding.allNews.setOnClickListener {
            findNavController().navigate(R.id.newsFragment)
        }
        binding.allPrevention.setOnClickListener {
            findNavController().navigate(R.id.preventionFragment)
        }

        binding.call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:1053")
            startActivity(intent)
        }



        return root
    }


    private fun setProgress() {
        dialog = AlertDialog.Builder(binding.root.context).create()
        val view = LayoutInflater.from(binding.root.context)
            .inflate(R.layout.custom_progress, null, false)
        dialog.setView(view)
        dialog.setContentView(view)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(false)
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = ""
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_navigation_icon)
    }

}