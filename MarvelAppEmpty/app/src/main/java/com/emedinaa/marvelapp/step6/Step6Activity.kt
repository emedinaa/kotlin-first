package com.emedinaa.marvelapp.step6

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.emedinaa.marvelapp.R
import com.emedinaa.marvelapp.adapter.GridItemDecorator
import com.emedinaa.marvelapp.step4.BaseActivity
import kotlinx.android.synthetic.main.activity_step6.*

class Step6Activity : BaseActivity() {

    private lateinit var adapter: HeroAdapter
    private lateinit var provider: HeroProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step6)

        provider= HeroProvider()

        adapter= HeroAdapter(emptyList())
        //recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= GridLayoutManager(this,2)
        recyclerView.addItemDecoration(GridItemDecorator(this,4,2))

        recyclerView.adapter= adapter

    }

}
