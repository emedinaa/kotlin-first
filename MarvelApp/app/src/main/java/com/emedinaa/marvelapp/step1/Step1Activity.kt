package com.emedinaa.marvelapp.step1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.emedinaa.marvelapp.R
import kotlinx.android.synthetic.main.activity_step1.*

class Step1Activity : AppCompatActivity() {

    var flag :Boolean= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step1)
        //supportActionBar?.setDisplayHomeAsUpEnabled(true)

        imageView.visibility= View.VISIBLE
        button.setOnClickListener {
            //imageView.visibility= View.VISIBLE
            //showImage()
            //switchImage()
            //changeImage()
            changeImage(2)
        }
    }

    private fun showImage(){
        imageView.visibility= View.VISIBLE
    }

    private fun switchImage(){
        val visibility= if(flag) View.GONE else View.VISIBLE
        imageView.visibility= visibility
        flag= !flag
    }

    private fun changeImage(){
        imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.hulk_box))
    }

    private fun changeImage(pos:Int){
        var image:Int

        when(pos){
            0 -> image= R.drawable.iron_man_box
            1 -> image= R.drawable.hulk_box
            2 -> image= R.drawable.scarlet_witch_box
            3 -> image= R.drawable.doctor_strange_box
            else -> image=0
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(this,image))
    }

    private fun changeImage2(pos:Int){
        var image= when(pos){
            0 -> R.drawable.iron_man_box
            1 -> R.drawable.hulk_box
            2 -> R.drawable.scarlet_witch_box
            3 -> R.drawable.doctor_strange_box
            else -> 0
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(this,image))

    }

    /*override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }*/
}
