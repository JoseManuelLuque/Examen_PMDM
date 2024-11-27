package com.jluqgon214.examen_pmdp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.jluqgon214.examen_pmdp.data.viewModel

@Composable
fun SecondScreen(navController: NavController, viewModel: viewModel) {
    //Elemento principal que ocupa toda la pantalla
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Bienvenido ${viewModel.usuario.value.nombre}" + " ${viewModel.usuario.value.apellidos}")
            Text("Edad: ${viewModel.usuario.value.edad}")
            Text("Teléfono: ${viewModel.usuario.value.telefono}")

        }
    }
}