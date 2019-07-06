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
    }

}
