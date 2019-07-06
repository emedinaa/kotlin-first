package com.emedinaa.marvelapp

data class Hero(val id:Int,val name:String, val des:String?, val photo:String)

data class HeroResponse(val status:Int?,val msg:String?,val data:List<Hero>){
    fun isSuccess():Boolean= (status==200)
}