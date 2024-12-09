package com.navfer.agendadam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.navfer.agendadam.databinding.ActivityListaContactosBinding
import java.util.function.Consumer

class ListaContactosFragment : Fragment() {
    private val viewModel: PersonaViewModel by activityViewModels()
    private var _binding: ActivityListaContactosBinding? = null
    private val binding get() = _binding!!

    private var onClick:Consumer<Persona>? = null
    private var onDoubleClick:Consumer<Persona>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityListaContactosBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configuración del RecyclerView
        val adaptador = Adaptador(
            viewModel.getItems(),
            Consumer { persona -> hacerClick(persona) },
            Consumer { persona -> hacerDobleClick(persona) }
        )

        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adaptador


        /**
         * Controla los eventos del BottomNavigation.
         * Al pulsar Add -> Navega al fragmento NuevaPersona.
         * Al pulsar Editar -> Navega al fragmento NuevaPersona para editar los datos de la Persona ya creada.
         * Al pulsar Borrar -> Elimina la persona de la lista de elementos.
         */
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.add -> {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .remove(this)
                        .add(R.id.fragmentContainerView, NuevaPersona())
                        .addToBackStack(null)
                        .commit()

                    true
                }


                R.id.editar -> {
                    TODO()
                }


                R.id.borrar -> {
                    TODO()
                }

                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //hacer click en el viewHolder
    private fun hacerClick(persona: Persona) {


    }

    // mantener pulsado viewholder
    private fun hacerDobleClick(persona: Persona) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, NuevaPersona())
            .addToBackStack(null)
            .commit()
    }




}
