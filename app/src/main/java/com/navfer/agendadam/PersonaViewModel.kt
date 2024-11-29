package com.navfer.agendadam

import androidx.lifecycle.ViewModel

class PersonaViewModel : ViewModel() {

    private var elementos= mutableListOf<Persona>()
    private var items: Persona? =null
    init{
        elementos.add(Persona("Pedro", "Picapiedra", "pedro@cantera.es", "555-1234",true))
        elementos.add( Persona("Pedro", "Picapiedra", "pedro@cantera.es", "555-1234",true))
        elementos.add(Persona("Vilma", "Traca de Picapiedra", "vilma@gmail.com", "555-2345",true))
        elementos.add(Persona("Pablo", "Marmol", "pablo@diario.com", "555-6543",true))


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
    public fun addItem(persona:Persona){

        this.elementos.add(persona)
       // this.elementos.sortDescending()
    }
    public fun getItem(index:Int):Persona{
        return this.elementos.get(index)
    }
    override fun onCleared() {
        this.elementos.removeAll{ true}
    }

}
