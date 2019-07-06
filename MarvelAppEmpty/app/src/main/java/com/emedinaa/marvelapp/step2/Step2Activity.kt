package com.emedinaa.marvelapp.step2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emedinaa.marvelapp.R
import kotlinx.android.synthetic.main.activity_step2.*

class Step2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step2)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView.visibility= View.VISIBLE
        button.setOnClickListener {
        }
    }


    /*override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
    }*/
}
