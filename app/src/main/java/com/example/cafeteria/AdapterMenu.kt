package com.example.cafeteria

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterMenu(
    private val context: Context,
    private val opcoes: List<Opcao>? = null,
    private val onClickListener: OpcaoOnClickListener
) : RecyclerView.Adapter<ViewHolderMenu>() {
    interface OpcaoOnClickListener {
        fun onClick(holder: ViewHolderMenu?, index: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolderMenu {
        val view = LayoutInflater.from(context).inflate(
            R.layout.opcao_adapter,
            viewGroup,
            false
        )
        return ViewHolderMenu(view)
    }

    override fun getItemCount(): Int = opcoes?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderMenu, position: Int) {
        val opcao = opcoes!![position]
        holder.titulo.text = opcao?.titulo
        holder.itemView.setOnClickListener { onClickListener.onClick(holder, position) }
    }
}

class ViewHolderMenu(view: View) : RecyclerView.ViewHolder(view) {
    var titulo: TextView = view.findViewById(R.id.tituloOpcao)
}