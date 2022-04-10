package uz.coder.hilt.adapters.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.coder.hilt.R
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.ItemArticleBinding

class HomeNewsAdapter(
    private val arrayList: ArrayList<NewsEntity>,
    val onItemClick: OnItemClick
) :
    RecyclerView.Adapter<HomeNewsAdapter.ViewH>() {

    inner class ViewH(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: NewsEntity) {

            itemView.animation = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim)

            Picasso.get().load(news.imageUrl).into(binding.image)
            binding.tv1.text = news.title
            binding.tv2.text = news.description


            itemView.setOnClickListener {
                onItemClick.click(news)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewH(ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount() = arrayList.size


    interface OnItemClick {
        fun click(news: NewsEntity)
    }


}