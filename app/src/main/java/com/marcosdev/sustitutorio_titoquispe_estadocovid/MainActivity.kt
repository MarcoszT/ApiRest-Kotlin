package com.marcosdev.sustitutorio_titoquispe_estadocovid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var resultResponses: List<ResModelItem>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        val btn = findViewById<Button>(R.id.btnBuscar)

        btn.setOnClickListener{
            val search = findViewById<TextView>(R.id.txtPais)
            val texto = search.text.toString()
            val txtconsulta = findViewById<TextView>(R.id.txtconsulta)
            val txtmuertos = findViewById<TextView>(R.id.txtmuertos)
            val txtrecuperados = findViewById<TextView>(R.id.txtrecuperados)
            val txtactualizacion = findViewById<TextView>(R.id.txtactualizacion)
            var filtered = resultResponses?.filter { it.Country_text == texto }

            if (filtered != null){
                if(filtered.isEmpty()){
                    Toast.makeText(this@MainActivity, "no hay, no existe", Toast.LENGTH_SHORT).show()
                }else{
                    txtconsulta.setText(filtered[0].TotalCases_text)
                    txtmuertos.setText(filtered[0].TotalDeaths_text)
                    txtrecuperados.setText(filtered[0].TotalRecovered_text)
                    txtactualizacion.setText(filtered[0].LastUpdate)
                }
            }
        }
    }

    private fun init(){
        val res = ServiceGenerator.build().getResults()
        res.enqueue(object : Callback<List<ResModelItem>>{
            override fun onResponse(
                call: Call<List<ResModelItem>>,
                response: Response<List<ResModelItem>>
            ) {
                resultResponses = response.body()
            }
            override fun onFailure(call: Call<List<ResModelItem>>, t: Throwable) {
                println(t.message)
            }
        })
    }
}