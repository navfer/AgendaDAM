package com.navfer.agendadam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.navfer.agendadam.databinding.ActivityListaContactosBinding
import java.util.function.Consumer

class ListaContactosFragment : Fragment() {
    private val viewModel: PersonaViewModel by activityViewModels()
    private var _binding: ActivityListaContactosBinding? = null
    private val binding get() = _binding!!

    //  -----------------------------------------------------------------------------------------------
    private var onAccept: Consumer<Persona>? = null
    /*
    private var onClick:
    private var onDoubleClick:

    ---------------------------------------------------------------------------------------------------
     */

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
        val adaptador = Adaptador(viewModel.getItems())
        val layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adaptador

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    public fun setOnAccept(Listener: Consumer<Persona>){
        onAccept = Listener
    }

}
