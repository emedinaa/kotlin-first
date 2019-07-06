package com.emedinaa.marvelapp.step5

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.emedinaa.marvelapp.R
import com.emedinaa.marvelapp.adapter.GridItemDecorator
import com.emedinaa.marvelapp.step3.HeroEntity
import com.emedinaa.marvelapp.step4.BaseActivity

import kotlinx.android.synthetic.main.activity_step5.*

class Step5Activity : BaseActivity() {

    private var heroList:MutableList<HeroEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step5)

        recyclerView.layoutManager= GridLayoutManager(this,2)
        recyclerView.addItemDecoration(GridItemDecorator(this,4,2))
        loadData()
    }

    private fun loadData(){
        heroList.add(HeroEntity("IronMan",R.drawable.iron_man_box,1))
        heroList.add(HeroEntity("Scarlet Witch",R.drawable.scarlet_witch_box,0))
        heroList.add(HeroEntity("Doctor Strange",R.drawable.doctor_strange_box,1))
        heroList.add(HeroEntity("Hulk",R.drawable.hulk_box,1))
        heroList.add(HeroEntity("Gamora",R.drawable.gamora_box,0))
        heroList.add(HeroEntity("Black Widow",R.drawable.black_widow_box,0))

        val adapter= HeroVAdapter(heroList.toList())
        recyclerView.adapter= adapter
    }
}
