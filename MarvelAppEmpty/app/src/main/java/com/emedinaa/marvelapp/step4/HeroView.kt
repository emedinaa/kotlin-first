package com.emedinaa.marvelapp.step4

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.emedinaa.marvelapp.step3.HeroEntity
import com.emedinaa.marvelapp.R
import kotlinx.android.synthetic.main.row_hero_h.view.*

class HeroView:FrameLayout {

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_hero_view, this, true)
    }
    constructor(context: Context):super(context,null){
        setUp()
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0){
        setUp()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setUp()
    }

    private fun setUp(){

    }

    fun setEntity(hero:HeroEntity){
        textView.text= hero.name
        imageView.setImageResource(hero.photo)
    }
}