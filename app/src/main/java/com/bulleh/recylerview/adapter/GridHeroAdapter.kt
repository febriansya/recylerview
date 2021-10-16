package com.bulleh.recylerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bulleh.recylerview.Obat
import com.bulleh.recylerview.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(val listObat: ArrayList<Obat>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {

    private lateinit var onItemClickCallback: ListObatAdapter.OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: ListObatAdapter.OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GridHeroAdapter.GridViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_tanaman,parent,false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridHeroAdapter.GridViewHolder, position: Int) {
      Glide.with(holder.itemView.context)
          .load(listObat[position].photo)
          .apply(RequestOptions().override(50,50))
          .into(holder.imagePhoto)


        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listObat[holder.adapterPosition])
        }

    }
    interface OnItemClickCallback {
        fun onItemClicked(data:Obat)
    }


    override fun getItemCount(): Int {
        return listObat.size
    }
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imagePhoto:ImageView  = itemView.findViewById(R.id.Image_Grid)


    }
}