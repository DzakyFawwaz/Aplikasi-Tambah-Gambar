package idn.jaki.aplikasitodogambar.recyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import idn.jaki.aplikasitodogambar.AddDataActivity
import idn.jaki.aplikasitodogambar.databinding.ItemDataBinding
import idn.jaki.aplikasitodogambar.model.ModelData
import idn.jaki.aplikasitodogambar.recyclerview.viewholder.ItemDataVH

class ItemDataAdapter : RecyclerView.Adapter<ItemDataVH>() {
    private var listData = arrayListOf<ModelData>()

    fun addData(data: List<ModelData>) {
        listData.clear()
        listData.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDataVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDataBinding.inflate(inflater, parent, false)
        return ItemDataVH(binding)
    }

    override fun onBindViewHolder(holder: ItemDataVH, position: Int) {
        val data = listData[position]
        holder.bind(data)

        holder.itemView.setOnClickListener { view ->
            val intent = Intent(view.context, AddDataActivity::class.java )
            intent.putExtra("DATA", data)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listData.size
}