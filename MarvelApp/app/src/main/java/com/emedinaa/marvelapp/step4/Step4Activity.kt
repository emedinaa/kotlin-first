package com.emedinaa.marvelapp.step4

import android.os.Bundle
import com.emedinaa.marvelapp.R
import com.emedinaa.marvelapp.step3.HeroEntity
import kotlinx.android.synthetic.main.activity_step4.*

class Step4Activity : BaseActivity(), GalleryDialogFragment.OnFragmentInteractionListener {


    private var photoSelected=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step4)

        textViewPhoto.setOnClickListener {
            showDialog()
        }

        button.setOnClickListener {
            createHero()
        }
    }

    private fun createHero(){
        val name = editTextName.text.toString().trim()
        //val desc = editTextDesc.text.toString().trim()
        val photo = photoSelected
        val hero= HeroEntity(name,photo,0)

        val heroView= HeroView(this)
        heroView.setEntity(hero)
        linerLayout.addView(heroView)
    }

    override fun onSelectedItem(position:Int,resource: Int) {
        textViewPhoto.text= "seleccionado $position"
        photoSelected= resource
    }

    private fun showDialog(){
        val galleryDialog:GalleryDialogFragment= GalleryDialogFragment.newInstance("","")
        galleryDialog.show(supportFragmentManager, "CustomDialogFragment");
    }
}
