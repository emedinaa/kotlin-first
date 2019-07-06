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

        //load Data
        //loadDataWithList()
        loadDataWithMutableList()

        //loadDataByGender()
        //loadDataByGender(1)
    }

    private fun loadDataByGender(gender:Int=0){
        val filter:MutableList<HeroEntity> = mutableListOf()
        heroList.forEach {
            if(it.gender==gender){
                filter.add(it)
            }
        }

        val adapter= HeroHAdapter(filter.toList())
        recyclerView.adapter= adapter
    }

    private fun loadDataWithMutableList(){
        heroList.add(HeroEntity("IronMan",R.drawable.iron_man_box,1))
        heroList.add(HeroEntity("Scarlet Witch",R.drawable.scarlet_witch_box,0))
        heroList.add(HeroEntity("Doctor Strange",R.drawable.doctor_strange_box,1))
        heroList.add(HeroEntity("Hulk",R.drawable.hulk_box,1))
        heroList.add(HeroEntity("Gamora",R.drawable.gamora_box,0))
        heroList.add(HeroEntity("Black Widow",R.drawable.black_widow_box,0))

        //heroList.sortBy { it.name }
        val adapter= HeroHAdapter(heroList.toList())
        recyclerView.adapter= adapter
    }

    private fun loadDataWithList(){
        val data:List<HeroEntity> = listOf(HeroEntity("IronMan",R.drawable.iron_man_box,1),
            HeroEntity("Scarlet Witch",R.drawable.scarlet_witch_box,0),HeroEntity("Doctor Strange",R.drawable.doctor_strange_box,1),
            HeroEntity("Hulk",R.drawable.hulk_box,1), HeroEntity("Gamora",R.drawable.gamora_box,0),
            HeroEntity("Black Widow",R.drawable.black_widow_box,0))

        val adapter= HeroHAdapter(data)
        recyclerView.adapter= adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
