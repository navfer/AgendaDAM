package com.navfer.agendadam

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

class Adaptador(private var elementos: MutableList<Persona>,
                private val onClick: Consumer<Persona>,
                private val onDoubleClick: Consumer<Persona> ): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    private var posicionSelecionada: Int = -1
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imagen: ImageView
        var nombre : TextView
        init {
            imagen = view.findViewById(R.id.imagen)
            nombre = view.findViewById(R.id.nombre)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.elementos.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val persona = elementos[holder.adapterPosition]
        holder.imagen.setImageResource(persona.image)
        holder.nombre.text = persona.nombre

        if (posicionSelecionada == holder.adapterPosition) {
            holder.itemView.setBackgroundResource(R.color.red)
        } else {
            holder.itemView.setBackgroundResource(android.R.color.transparent)
        }

        holder.itemView.setOnClickListener {
            posicionSelecionada = holder.adapterPosition
            onClick.accept(persona)
            notifyItemChanged(holder.adapterPosition)
        }

        holder.itemView.setOnLongClickListener {
            onDoubleClick.accept(persona)
            true
        }
    }



}