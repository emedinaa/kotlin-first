package com.emedinaa.marvelapp.step1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.emedinaa.marvelapp.R
import kotlinx.android.synthetic.main.activity_step1.*

class Step1Activity : AppCompatActivity() {

    private val hero:String= "Iron Man"
    private var message="He privatizado exitosamente la paz mundial!"
    private var desc:String?=null
    private val gender:Int =1
    private var photo:Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step1)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        desc= "También conocido en español como el Hombre de Hierro — es un superhéroe ficticio que aparece en los cómics estadounidenses publicados por Marvel Comics. "
        imageView.setOnClickListener {
            showMessage()
        }
    }

    private fun showMessage(){

        val nMessage= hero.plus(" ").plus(message)
        Toast.makeText(this,nMessage,Toast.LENGTH_LONG).show()
    }

    /*override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }*/
}
