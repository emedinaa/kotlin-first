package com.emedinaa.marvelapp.step3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.marvelapp.R

class HeroHAdapter(private val heroList:List<HeroEntity>):RecyclerView.Adapter<HeroHAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_hero_h, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val hero= heroList[position]

        vh.textView.text= hero.name
        vh.imageView.setImageResource(hero.photo)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
}