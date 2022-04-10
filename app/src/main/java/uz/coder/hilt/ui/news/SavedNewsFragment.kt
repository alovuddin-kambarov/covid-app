package uz.coder.hilt.ui.news

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.coder.hilt.R
import uz.coder.hilt.adapters.rv_adapters.SavedNewsAdapter
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.FragmentSavedNewsBinding
import uz.coder.hilt.viewmodels.NewsViewModel

@AndroidEntryPoint
class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {

    private val viewModel: NewsViewModel by viewModels()
    private val binding: FragmentSavedNewsBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSavedNews().observe(viewLifecycleOwner) {

            binding.rv.adapter = SavedNewsAdapter(
                it as ArrayList<NewsEntity>,
                object : SavedNewsAdapter.OnItemClick {
                    override fun click(news: NewsEntity) {

                    }

                    override fun removeSaveClick(news: NewsEntity) {
                        val arrayList = ArrayList<NewsEntity>()
                        news.isSave = 0
                        arrayList.add(news)
                        viewModel.insertSavedNews(arrayList)
                    }
                })

        }

    }

}