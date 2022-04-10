package uz.coder.hilt.adapters.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.coder.hilt.R
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.ItemSavedNewsBinding

class SavedNewsAdapter(private val arrayList: ArrayList<NewsEntity>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<SavedNewsAdapter.ViewH>() {

    inner class ViewH(private val binding: ItemSavedNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: NewsEntity) {

            itemView.animation = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim2)

            Picasso.get().load(news.imageUrl).into(binding.image)
            binding.title.text = news.title
            binding.description.text = news.description

            binding.save.setOnClickListener {
                onItemClick.removeSaveClick(news)
            }


            itemView.setOnClickListener {
                onItemClick.click(news)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewH(ItemSavedNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount() = arrayList.size


    interface OnItemClick {
        fun click(news: NewsEntity)
        fun removeSaveClick(news: NewsEntity)
    }


}