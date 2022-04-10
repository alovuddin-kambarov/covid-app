package uz.coder.hilt.adaptersimport android.view.LayoutInflaterimport android.view.Viewimport android.view.ViewGroupimport android.widget.BaseAdapterimport com.squareup.picasso.Picassoimport uz.coder.hilt.databinding.SpinnerItemBindingimport uz.coder.hilt.models.SpinnerDataclass SpinnerAdapter(var list: ArrayList<SpinnerData>) :    BaseAdapter() {    override fun getCount(): Int {        return list.size    }    override fun getItem(position: Int): SpinnerData {        return list[position]    }    override fun getItemId(position: Int): Long {        return position.toLong()    }    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {        val spinnerItemBinding: SpinnerItemBinding = if (convertView == null) {            SpinnerItemBinding.inflate(                LayoutInflater.from(parent.context),                parent,                false            )        } else {            SpinnerItemBinding.bind(convertView)        }        spinnerItemBinding.currencyText.text = list[position].text        Picasso.get().load(list[position].flag).into(spinnerItemBinding.flagImage)        return spinnerItemBinding.root    }}