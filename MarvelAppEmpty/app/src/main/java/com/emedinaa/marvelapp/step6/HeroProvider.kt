package com.emedinaa.marvelapp.step6

import com.emedinaa.marvelapp.Hero
import com.emedinaa.marvelapp.HeroResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroProvider {

    private  var call:Call<HeroResponse>?=null

    init {
        call=  ApiClient.build()?.heroes()
    }

    fun retrieveHeroes(result:(data:DataResult<List<Hero>>)->Unit){
        call?.enqueue(object :Callback<HeroResponse>{
            override fun onFailure(call: Call<HeroResponse>, t: Throwable) {
                if(!call.isCanceled){
                    result(DataResult.Failure(Exception(t.message)))
                }
            }

            override fun onResponse(call: Call<HeroResponse>, response: Response<HeroResponse>) {
                response?.body()?.let {
                    when(it.status){
                        200 -> result(DataResult.Success(it.data))
                        else -> result(DataResult.Failure(Exception(it.msg)))
                    }
                }
            }
        })
    }
}