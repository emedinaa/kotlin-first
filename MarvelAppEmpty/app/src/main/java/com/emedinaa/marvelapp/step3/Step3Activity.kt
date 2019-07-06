package com.emedinaa.marvelapp.step3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.emedinaa.marvelapp.R
import kotlinx.android.synthetic.main.activity_step3.*

class Step3Activity : AppCompatActivity() {

    //private var heroList:MutableList<HeroEntity>?=null
    private var heroList:MutableList<HeroEntity> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step3)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager= layoutManager

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
