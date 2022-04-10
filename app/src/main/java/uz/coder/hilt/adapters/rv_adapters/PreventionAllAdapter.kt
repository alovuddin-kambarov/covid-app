package uz.coder.hilt.adapters.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.coder.hilt.R
import uz.coder.hilt.databinding.ItemAllPreventionBinding
import uz.coder.hilt.models.Prevention

class PreventionAllAdapter(private val arrayList: ArrayList<Prevention>, val onItemClick: OnItemClick) :
    RecyclerView.Adapter<PreventionAllAdapter.ViewH>() {

    inner class ViewH(private val binding: ItemAllPreventionBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun onBind(prevention: Prevention){

                itemView.animation = AnimationUtils.loadAnimation(binding.root.context, R.anim.anim2)

                binding.image.setImageResource(prevention.image)
                binding.tv1.text = prevention.title
                binding.tv2.text = prevention.description

                itemView.setOnClickListener {
                    onItemClick.click(prevention)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewH(ItemAllPreventionBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount() = arrayList.size

    interface OnItemClick{
        fun click(prevention: Prevention)
    }



}