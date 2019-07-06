package com.emedinaa.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.emedinaa.marvelapp.step1.Step1Activity
import com.emedinaa.marvelapp.step2.Step2Activity
import com.emedinaa.marvelapp.step3.Step3Activity
import com.emedinaa.marvelapp.step4.Step4Activity
import com.emedinaa.marvelapp.step4.goToActivity
import com.emedinaa.marvelapp.step5.Step5Activity
import com.emedinaa.marvelapp.step6.Step6Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        val activity = when(v.id){
            R.id.button1 -> Step1Activity::class.java
            R.id.button2 -> Step2Activity::class.java
            R.id.button3 -> Step3Activity::class.java
            R.id.button4 -> Step4Activity::class.java
            R.id.button5 -> Step5Activity::class.java
            R.id.button6 -> Step6Activity::class.java
            else -> null
        }

        activity?.let {
            goToActivity(Bundle(),it)
        }
    }
}
