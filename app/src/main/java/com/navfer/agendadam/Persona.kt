package com.navfer.agendadam

import kotlin.random.Random

data class Persona(
    var id: Int,
    var nombre: String,
    var apellidos: String,
    var email: String,
    var telefono: String,
    var activo: Boolean,
    var image: Int = AVATARvalues.random()
) {
    companion object {
        val AVATARvalues = arrayOf(
            R.drawable.avatar_1,
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
}
