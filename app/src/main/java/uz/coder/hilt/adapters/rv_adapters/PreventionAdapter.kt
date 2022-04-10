package uz.coder.hilt.adapters.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.coder.hilt.R
import uz.coder.hilt.databinding.ItemPreventionBinding
import uz.coder.hilt.models.Prevention

class PreventionAdapter(private val arrayList: ArrayList<Prevention>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<PreventionAdapter.ViewH>() {

    inner class ViewH(private val binding: ItemPreventionBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun onBind(prevention: Prevention){

                itemView.animation = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim)

                binding.image.setImageResource(prevention.image)
                binding.tv1.text = prevention.title
                binding.tv2.text = prevention.description

                itemView.setOnClickListener {
                    onItemClick.click(prevention)
                }

            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewH(ItemPreventionBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount() = arrayList.size

    interface OnItemClick{
        fun click(prevention: Prevention)
    }


}
