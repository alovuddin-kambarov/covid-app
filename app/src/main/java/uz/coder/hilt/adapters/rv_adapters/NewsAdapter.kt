package uz.coder.hilt.adapters.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import uz.coder.hilt.R
import uz.coder.hilt.database.entity.NewsEntity
import uz.coder.hilt.databinding.ItemNewsBinding

class NewsAdapter(private val arrayList: ArrayList<NewsEntity>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<NewsAdapter.ViewH>() {

    inner class ViewH(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(news: NewsEntity) {

            itemView.animation = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim2)

            Picasso.get().load(news.imageUrl).into(binding.image)
            binding.title.text = news.title
            binding.description.text = news.description

            binding.remove.setOnClickListener {
                arrayList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }

            if (news.isSave == 1) {
                binding.save.setImageResource(R.drawable.ic_saved_selected)
            } else {
                binding.save.setImageResource(R.drawable.ic_saved_unselected)
            }

            binding.save.setOnClickListener {
                onItemClick.saveClick(news, binding.save)
            }

            itemView.setOnClickListener {
                onItemClick.click(news)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewH(ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount() = arrayList.size


    interface OnItemClick {
        fun click(news: NewsEntity)
        fun saveClick(news: NewsEntity, saveImage:ImageView)
    }


}