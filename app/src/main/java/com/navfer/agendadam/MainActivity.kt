package com.navfer.agendadam

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import com.navfer.agendadam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {
    private val viewModel: PersonaViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_add, R.id.item_lista -> {
                onNavigationItemSelected(item)
                true
            }

                android.R.id.home->{
                    supportFragmentManager.popBackStack()
                    binding.toolbar.setTitle("Agenda DAM")
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                    binding.toolbar.menu.findItem(R.id.item_add)?.isVisible = true
                    binding.toolbar.menu.findItem(R.id.item_lista)?.isVisible = true

                    true
                }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_add -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView,NuevaPersona())
                    .addToBackStack(null)
                    .commit()

                //personas.add(it)


                //Ajustes en el toolbar
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                binding.toolbar.setTitle("Nuevo Contacto")
                binding.toolbar.menu.findItem(R.id.item_add)?.isVisible = false
                binding.toolbar.menu.findItem(R.id.item_lista)?.isVisible = true

                true
            }

            R.id.item_lista -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView,ListaContactosFragment())
                    .addToBackStack(null)
                    .commit()

                //Ajustes en el toolbar
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                binding.toolbar.setTitle("Lista Contactos")
                binding.toolbar.menu.findItem(R.id.item_lista)?.isVisible = false
                binding.toolbar.menu.findItem(R.id.item_add)?.isVisible = true

                true
            }

            else -> false
        }
    }

}
