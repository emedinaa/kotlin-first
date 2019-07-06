package com.emedinaa.marvelapp.step6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.emedinaa.marvelapp.Hero
import com.emedinaa.marvelapp.R
import com.emedinaa.marvelapp.adapter.RecyclerClickListener
import com.emedinaa.marvelapp.adapter.RecyclerTouchListener
import com.emedinaa.marvelapp.step4.showToast
import kotlinx.android.synthetic.main.activity_step6.*

class Step6Activity : AppCompatActivity() {

    private lateinit var adapter: HeroAdapter
    private lateinit var provider: HeroProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step6)

        provider= HeroProvider()

        adapter= HeroAdapter(emptyList())
        //recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= GridLayoutManager(this,2)
        recyclerView.adapter= adapter

        recyclerView.addOnItemTouchListener(RecyclerTouchListener(this,recyclerView,
            object:RecyclerClickListener{
                override fun onClick(view: View, position: Int) {
                    val item= adapter.getItem(position)
                    showItem(item)
                }
                override fun onLongClick(view: View, position: Int) {

                }
            }))
    }

    private fun  showItem(hero:Hero){
        showToast("Hero ${hero.name}")
    }
    private fun renderData(data:List<Hero>){
        adapter.update(data)
        //recyclerView.adapter= HeroAdapter(data)
    }

    private fun empty(){}

    private fun showError(message:String?){}

    private fun onResult():(data:DataResult<List<Hero>>)->Unit{
        return {
            when(it){
                is DataResult.Success ->
                    if(it.data.isEmpty()){
                        empty()
                    }else{
                        renderData(it.data)
                    }
                is DataResult.Failure -> showError(it.e.message)
            }
        }
    }
    override fun onResume() {
        super.onResume()
        /*provider.retrieveHeroes {
            when(it){
                is DataResult.Success ->
                    if(it.data.isEmpty()){
                        empty()
                    }else{
                        renderData(it.data)
                    }
                is DataResult.Failure -> showError(it.e.message)
            }
        }*/

        provider.retrieveHeroes(onResult())
    }
}
