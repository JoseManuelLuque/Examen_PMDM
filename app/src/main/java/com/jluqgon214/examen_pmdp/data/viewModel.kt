package com.jluqgon214.examen_pmdp.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jluqgon214.examen_pmdp.model.Usuario


// Para la persistencia de los datos he optado por usar un ViewModel para que así todas las capas de mi aplicacion puedan acceder a ellos
class viewModel : ViewModel() {
    private val _usuario = mutableStateOf(Usuario())
    val usuario: State<Usuario> = _usuario

    private val _nombre = mutableStateOf("")
    val nombre: State<String> = _nombre

    private val _apellidos = mutableStateOf("")
    val apellidos: State<String> = _apellidos

    private val _edad = mutableStateOf(0)
    val edad: State<Int> = _edad

    private val _telefono = mutableStateOf(0)
    val telefono: State<Int> = _telefono

    fun updateUsuario(usuario: Usuario) {
        _usuario.value = usuario
    }

    fun updateNombre(nombre: String) {
        _nombre.value = nombre
    }

    fun updateApellidos(apellidos: String) {
        _apellidos.value = apellidos
    }

    fun updateEdad(edad: Int) {
        _edad.value = edad
    }

    fun updateTelefono(telefono: Int) {
        _telefono.value = telefono
    }

}