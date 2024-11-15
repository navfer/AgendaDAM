package com.navfer.agendadam

import kotlin.random.Random

class Persona {
    private companion object{
        val AVATARvalues= arrayOf( R.drawable.avatar_1,
            R.drawable.avatar_2,
            R.drawable.avatar_3,
            R.drawable.avatar_4,
            R.drawable.avatar_5,
            R.drawable.avatar_6,
            R.drawable.avatar_7,
            R.drawable.avatar_8,
            R.drawable.avatar_9,
            R.drawable.avatar_10,
            R.drawable.avatar_11,
            R.drawable.avatar_12,
            R.drawable.avatar_13,
            R.drawable.avatar_14,
            R.drawable.avatar_15,
            R.drawable.avatar_16
        )
    }
        private var nombre: String = ""
        private var apellidos: String = ""
        private var email: String = ""
        private var activo: Boolean = false
        private var telefono:String=""
        private var image:Int= -1
        constructor(nombre: String, apellidos: String, email: String, telefono:String,activo: Boolean) {
            this.nombre = nombre
            this.apellidos = apellidos
            this.email = email
            this.activo = activo
            this.telefono=telefono
            this.image=Persona.AVATARvalues.get(Random.nextInt(0, 15))
        }

        constructor() {
        }

        fun getNombre(): String {
            return nombre
        }
        fun getImagen():Int{
            return this.image
        }
        fun setNombre(nuevoNombre: String) {
            nombre = nuevoNombre
        }
        fun getApellidos(): String {
            return apellidos
        }
        fun setApellidos(nuevosApellidos: String) {
            apellidos = nuevosApellidos
        }
        // Getter para el atributo email
        fun getEmail(): String {
            return email
        }
        // Setter para el atributo email
        fun setEmail(nuevoEmail: String) {
            email = nuevoEmail
        }
        // Getter para el atributo email
        fun getTelefono(): String {
            return telefono
        }

        // Setter para el atributo email
        fun setTelefono(nuevo: String) {
            telefono = nuevo
        }
        // Getter para el atributo activo
        fun isActivo(): Boolean {
            return activo
        }
        fun setActivo(nuevoActivo: Boolean) {
            activo = nuevoActivo
        }


        public fun clone(): Persona {
            val nuevaPersona = Persona()
            nuevaPersona.nombre = this.nombre
            nuevaPersona.apellidos = this.apellidos
            nuevaPersona.email = this.email
            nuevaPersona.activo = this.activo
            nuevaPersona.telefono=this.telefono
            return nuevaPersona
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || javaClass != other.javaClass) return false
            val otraPersona = other as Persona
            if (nombre != otraPersona.nombre) return false
            if (apellidos != otraPersona.apellidos) return false
            if (email != otraPersona.email) return false
            if (telefono != otraPersona.telefono) return false
            if (activo != otraPersona.activo) return false
            return true
        }

        override fun hashCode(): Int {
            var result = nombre.hashCode()
            result = 31 * result + apellidos.hashCode()
            result = 31 * result + email.hashCode()
            result = 31 * result + telefono.hashCode()
            result = 31 * result + activo.hashCode()
            return result
        }
}