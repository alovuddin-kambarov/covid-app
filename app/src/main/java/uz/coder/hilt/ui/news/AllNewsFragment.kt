package uz.coder.hilt.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.coder.hilt.R
import uz.coder.hilt.adapters.rv_adapters.NewsAdapter
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.FragmentAllNewsBinding
import uz.coder.hilt.ui.AboutActivity
import uz.coder.hilt.utils.NewsResource
import uz.coder.hilt.viewmodels.NewsViewModel

@AndroidEntryPoint
class AllNewsFragment : Fragment(R.layout.fragment_all_news) {

    private val binding: FragmentAllNewsBinding by viewBinding()
    private val myViewModel: NewsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        myViewModel.getNewsAndArticle().observe(viewLifecycleOwner) {
            when (it) {
                is NewsResource.Error -> {
                    println("alovuddin: ${it.message}")
                    Toast.makeText(binding.root.context, it.message, Toast.LENGTH_SHORT).show()
                }
                NewsResource.Loading -> {
                    println("alovuddin: loading...")
                }
                is NewsResource.Success -> {
                    println("alovuddin: ${it.list}")
                    binding.rv.adapter = NewsAdapter(
                        it.list as ArrayList<NewsEntity>,
                        object : NewsAdapter.OnItemClick {
                            override fun click(news: NewsEntity) {

                                startActivity(
                                    Intent(
                                        binding.root.context,
                                        AboutActivity::class.java
                                    ).putExtra("news", news).putExtra("key", false)
                                )
                            }

                            override fun saveClick(news: NewsEntity, saveImage: ImageView) {

                                if (news.isSave == 1) {
                                    news.isSave = 0
                                    val arrayList = ArrayList<NewsEntity>()
                                    arrayList.add(news)
                                    saveImage.setImageResource(R.drawable.ic_saved_unselected)
                                    myViewModel.insertSavedNews(arrayList)
                                } else {
                                    news.isSave = 1
                                    val arrayList = ArrayList<NewsEntity>()
                                    saveImage.setImageResource(R.drawable.ic_saved_selected)
                                    arrayList.add(news)
                                    myViewModel.insertSavedNews(arrayList)
                                }
                            }


                        })


                }
            }


        }

    }




}