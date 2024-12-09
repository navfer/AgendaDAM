package com.navfer.agendadam

import androidx.lifecycle.ViewModel

class PersonaViewModel : ViewModel() {

    private var elementos= mutableListOf<Persona>()
    private var items: Persona? =null
    private var _cont: Int = 0
    private val cont get() = _cont

    //Persona de ejemplo para pruebas
    init{
        elementos.add(Persona(0,"Ejemplo", "Motos", "pablomotos@gmail.es", "966123478",true))
    }
    public fun setSelected(index:Int){
        this.items=this.elementos.get(index)
    }

    public fun setSelected(persona:Persona){
        this.items=persona
    }

    public fun getSelected():Persona?{
        return this.items
    }

    public fun getItems(): MutableList<Persona>{
        return this.elementos
    }

    /**
     * Funcion que añade nueva persona a la lista de elementos. Desde aqui controlamos la ID que tomará el elemento creado.
     */
    public fun addItem(nombre: String,apellido: String, email: String, telefono:String){
        var id = cont + 1
        var nuevaPersona = Persona(id,nombre,apellido,email,telefono,true)
        this.elementos.add(nuevaPersona)
        _cont++
        this.elementos.sortBy { it.nombre }
    }

    public fun getItem(index:Int):Persona{
        return this.elementos.get(index)
    }

    override fun onCleared() {
        this.elementos.removeAll{ true}
    }



}
