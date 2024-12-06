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
