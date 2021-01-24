package com.example.frasedodia.data

import android.util.Log
import org.json.JSONObject
import java.net.URL

class Request(private val url: String){
    fun run() : String{
        val forecastJson = URL(url).readText()
        var strJson = JSONObject(forecastJson.toString().replace("JSON_CALLBACK(","").replace(")",""))
        Log.d("onpoint", strJson.getString("quoteText"))
       return strJson.getString("quoteText")
    }
}