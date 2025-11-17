package com.example.cafeteria

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var opcoes: List<Opcao>? = null
    private lateinit var adapter: AdapterMenu
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar1))

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        val img = findViewById<ImageView>(R.id.imageView)
        img.setImageResource(R.drawable.cafeteria)

        recyclerView = findViewById(R.id.recyclerViewMenu)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.setHasFixedSize(true)

        opcoes = OpcoesMenu.getOpcoesMenu()

        adapter = AdapterMenu(this, opcoes, onClickOpcao())
        recyclerView.adapter = adapter
    }

    private fun onClickOpcao(): AdapterMenu.OpcaoOnClickListener {
        return object : AdapterMenu.OpcaoOnClickListener {
            override fun onClick(holder: ViewHolderMenu?, index: Int) {
                val opcaoSelecionada = opcoes?.get(index)?.titulo

                when (opcaoSelecionada) {
                    "Bebidas" -> {
                        intent = Intent(this@MainActivity, BebidasActivity::class.java)
                        intent.putExtra("Bebidas", opcaoSelecionada)
                        startActivity(intent)
                    }

                    else -> {
                        Toast.makeText(
                            this@MainActivity,
                            "Ainda não estamos funcionando com ${opcaoSelecionada?.lowercase()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}