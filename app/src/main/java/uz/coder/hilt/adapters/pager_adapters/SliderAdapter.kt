package uz.coder.hilt.adapters.pager_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import uz.coder.hilt.databinding.ItemGlobalNewsBinding
import uz.coder.hilt.models.GlobalNews


class SliderAdapter(private val arraylist: ArrayList<GlobalNews>,  val onClick: OnClick) :
    RecyclerView.Adapter<SliderAdapter.ViewH>() {

    inner class ViewH(var binding: ItemGlobalNewsBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(myClass: GlobalNews) {

            Picasso.get().load(myClass.image).into(binding.image, object :Callback{
                override fun onSuccess() {
                }

                override fun onError(e: Exception?) {

                }
            })


            binding.description.text = myClass.description
            binding.type.text = myClass.type

            itemView.setOnClickListener {
                onClick.click(myClass)
            }



        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewH {

        return ViewH(
            ItemGlobalNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.onBind(arraylist[position])

    }

    interface OnClick{

        fun click(movieClass: GlobalNews)

    }

}