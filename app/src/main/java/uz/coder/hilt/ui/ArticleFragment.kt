package uz.coder.hilt.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.coder.hilt.R
import uz.coder.hilt.adapters.rv_adapters.ArticleAdapter
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.FragmentArticleBinding
import uz.coder.hilt.utils.NewsResource
import uz.coder.hilt.viewmodels.NewsViewModel

@AndroidEntryPoint
class ArticleFragment : Fragment(R.layout.fragment_article) {

    private val viewModel: NewsViewModel by viewModels()
    private val binding: FragmentArticleBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getNewsAndArticle().observe(viewLifecycleOwner) {

            when (it) {
                is NewsResource.Error -> {

                }
                NewsResource.Loading -> {

                }
                is NewsResource.Success -> {


                    val aaa = object : ArticleAdapter.OnItemClick {
                        override fun click(newsEntity: NewsEntity) {

                            startActivity(
                                Intent(
                                    binding.root.context,
                                    AboutActivity::class.java
                                ).putExtra("news", newsEntity).putExtra("key", false)
                            )
                        }
                    }

                    binding.rv.adapter = ArticleAdapter(it.list as ArrayList<NewsEntity>, aaa)

                }
            }


        }


    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Article"
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeButtonEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_navigation_icon)
    }
}
