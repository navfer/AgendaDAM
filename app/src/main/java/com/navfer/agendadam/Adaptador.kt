package com.navfer.agendadam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.function.Consumer

class Adaptador(private var elementos: MutableList<Persona>,
                private val onClick: Consumer<Persona>,
                private val onDoubleClick: Consumer<Persona> ): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    private var posicionSelect: Int?= null
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
        holder.imagen.setImageResource(this.elementos.get(position).getImagen())
        holder.nombre.text=(this.elementos.get(position).getNombre())
        val persona = elementos[position]

        if(posicionSelect == position){
            holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.red))
        }else{
            android.R.color.transparent
        }

        

    }

}