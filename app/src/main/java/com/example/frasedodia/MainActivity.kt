package com.example.frasedodia

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.frasedodia.data.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    //lateinit variavel inicializada depois
    lateinit var texto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById(R.id.txtNovaFrase) as TextView
    }

    fun gerarFrase(view: View) {
        val url = "https://api.forismatic.com/api/1.0/?method=getQuote&lang=en&format=jsonp&jsonp=JSON_CALLBACK"
        doAsync {
            texto.text = Request(url).run()
            //uiThread { toast("Request performed") }
        }
    }


}