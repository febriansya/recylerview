package com.bulleh.recylerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bulleh.recylerview.Obat
import com.bulleh.recylerview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListObatAdapter(private val listObat: ArrayList<Obat>) :
    RecyclerView.Adapter<ListObatAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback:OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback:OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }




    //    mengambil view.xml yang sudah di buat di layout dengan nama item_tanaman_obat
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tanaman_obat, parent, false)
        return ListViewHolder(view)
    }

    //    parsing data dari database ke tampilan
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val obat = listObat[position]
        Glide.with(holder.itemView)
            .load(obat.photo)
            .apply(RequestOptions().override(50, 50))
            .into(holder.image)

        holder.tvName.text = obat.name
        holder.tvDetail.text = obat.detail

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listObat[holder.adapterPosition])
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data:Obat)
    }



    //    menghitung banyak data
    override fun getItemCount(): Int {
        return listObat.size
    }

    //    inisisalisai id dari item_tanaman_obat
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var image: ImageView = itemView.findViewById(R.id.image_obat)
    }

}
