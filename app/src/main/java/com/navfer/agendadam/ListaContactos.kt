package com.navfer.agendadam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.navfer.agendadam.databinding.ActivityListaContactosBinding // Asegúrate de importar el binding correcto

class ListaContactos : AppCompatActivity() {
    private lateinit var binding: ActivityListaContactosBinding // Cambia el tipo aquí

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListaContactosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuración del RecyclerView
        val adaptador = Adaptador()
        val layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adaptador

        // Barra lateral (si tienes)
        setSupportActionBar(binding.toolbar)
        //binding.navigator.setNavigationItemSelectedListener(this)
    }
}
