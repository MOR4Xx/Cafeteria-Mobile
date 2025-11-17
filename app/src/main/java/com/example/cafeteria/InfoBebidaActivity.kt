package com.example.cafeteria

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class InfoBebidaActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_bebida)

        setSupportActionBar(findViewById(R.id.toolbar3))
        supportActionBar?.title = intent.getStringExtra("titulo")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val imagem = intent.getIntExtra("imagem", 0)
        val bebida = intent.getStringExtra("titulo")
        val descricao = intent.getStringExtra("descricao")

        val textTitulo : TextView = findViewById(R.id.tituloBebida)
        val textDescricao : TextView = findViewById(R.id.descricaoBebida)
        val imageView: ImageView = findViewById(R.id.imageBebida)

        textTitulo.text = bebida
        textDescricao.text = descricao
        if(imagem != 0){
            imageView.setImageResource(imagem)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}