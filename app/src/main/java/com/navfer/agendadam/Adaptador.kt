package com.navfer.agendadam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptador: RecyclerView.Adapter<Adaptador.ViewHolder>() {

    private var elementos= arrayListOf( Persona("Pedro", "Picapiedra",
        "pedro@cantera.es", "555-1234",true),
        Persona("Vilma", "Traca de Picapiedra", "vilma@gmail.com", "555-2345",true),
        Persona("Pablo", "Marmol", "pablo@diario.com", "555-6543",true),
        Persona("Betty", "Llergo de Mármol", "betty@yahoo.es", "555-7890",true),
        )


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
    }

}