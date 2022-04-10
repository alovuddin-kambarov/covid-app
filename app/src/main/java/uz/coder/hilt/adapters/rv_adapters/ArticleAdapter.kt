package uz.coder.hilt.adapters.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.coder.hilt.R
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.ItemAllArticleBinding

class ArticleAdapter(private val arrayList: ArrayList<NewsEntity>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<ArticleAdapter.ViewH>() {

    inner class ViewH(private val binding: ItemAllArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(prevention: NewsEntity) {


            itemView.animation = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim2)

            Picasso.get().load(prevention.imageUrl).into(binding.image)
            binding.tv1.text = prevention.title
            binding.tv2.text = prevention.description

            itemView.setOnClickListener {
                onItemClick.click(prevention)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewH(ItemAllArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount() = arrayList.size

    interface OnItemClick{
        fun click(newsEntity: NewsEntity)
    }

}