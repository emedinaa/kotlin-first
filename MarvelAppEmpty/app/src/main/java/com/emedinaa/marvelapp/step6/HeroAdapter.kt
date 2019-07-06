package com.emedinaa.marvelapp.step6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.marvelapp.Hero
import com.emedinaa.marvelapp.R
import com.squareup.picasso.Picasso


class HeroAdapter(private var heroList:List<Hero>): RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HeroAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_hero_h, parent, false)
        return HeroAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(vh: HeroAdapter.ViewHolder, position: Int) {
        val hero= heroList[position]

        vh.textView.text= hero.name
        //Glide.with(vh.imageView.context).load(hero.photo).into(vh.imageView)
        Picasso.get()
            .load(hero.photo)
            .into(vh.imageView)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    fun getItem(position: Int):Hero{
        return heroList[position]
    }

    fun update(data:List<Hero>){
        heroList= data
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.textView)
        val imageView: ImageView = view.findViewById(R.id.imageView)
    }
}