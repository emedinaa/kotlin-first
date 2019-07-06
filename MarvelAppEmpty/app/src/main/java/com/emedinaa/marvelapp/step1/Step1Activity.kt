package com.emedinaa.marvelapp.step1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emedinaa.marvelapp.R
import kotlinx.android.synthetic.main.activity_step1.*

class Step1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step1)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView.setOnClickListener {

        }
    }


    /*override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }*/
}
