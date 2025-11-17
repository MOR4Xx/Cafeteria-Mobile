package com.example.cafeteria

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BebidasActivity: AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterMenu
    private var opcoes: List<Opcao>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bebidas)

        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar?.title = intent.getStringExtra("Bebidas")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerViewOpcoes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.setHasFixedSize(true)

        opcoes = OpcoesBebidas.getBebidas()

        adapter = AdapterMenu(this, opcoes, object : AdapterMenu.OpcaoOnClickListener {
            override fun onClick(holder: ViewHolderMenu?, index: Int) {
                val bebida = opcoes?.get(index)
                Toast.makeText(this@BebidasActivity, "Você escolheu $bebida", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@BebidasActivity, InfoBebidaActivity::class.java)

                intent.putExtra("titulo", bebida?.titulo)
                intent.putExtra("descricao", bebida?.descricao)
                intent.putExtra("imagem", bebida?.imagem)
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}