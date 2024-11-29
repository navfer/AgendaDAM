package com.navfer.agendadam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.navfer.agendadam.databinding.ActivityListaContactosBinding
import com.navfer.agendadam.databinding.ActivityNuevocontactoBinding

class NuevaPersona: Fragment() {

    private var _binding: ActivityNuevocontactoBinding? = null
    private val binding get() = _binding!!
    //Recupera viewModel actividad padre -> by activityViewModels()
    private val viewModel: PersonaViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityNuevocontactoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonConfirmar.setOnClickListener{
            var nombre = binding.etNombre.text.toString()
            var apellido = binding.etApellido.text.toString()
            var email = binding.etEmail.text.toString()
            var telefono = binding.etTelefono.text.toString()

            var nuevaPersona = Persona(nombre,apellido,email,telefono,true)
            viewModel.addItem(nuevaPersona)
            parentFragmentManager.popBackStack()
            parentFragmentManager.popBackStack()


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}