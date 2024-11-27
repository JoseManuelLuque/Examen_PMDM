package com.jluqgon214.examen_pmdp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jluqgon214.examen_pmdp.data.viewModel
import com.jluqgon214.examen_pmdp.model.Usuario
import com.jluqgon214.examen_pmdp.ui.theme.Fuente
import com.jluqgon214.examen_pmdp.ui.theme.colorBoton

@Composable
fun MainScreen(navController: NavController, viewModel: viewModel) {
    //Contexto para los toast
    val context = LocalContext.current

    //Elemento principal que ocupa toda la pantalla
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                //OCupamos toda la pantalla
                .fillMaxSize()
                //Le ponemos un pading vertiaal y horizontal usando tambien el innerpadding que nos proporciona el Scafold
                .padding(horizontal = 24.dp, vertical = innerPadding.calculateTopPadding()),
            // Centramos el contenido en el centro de la pantalla
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Iniciar sesión",
                    fontSize = 26.sp,
                    //He añadido una fuente para cambiar un poco, es fea de cojones pero es para que se vea distinta
                    fontFamily = Fuente
                )
            }

            //Mtemeos los 3 TextField en una columna para poder separarlos un poco
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            )
            {// TextField para el nombre
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.nombre.value,
                    onValueChange = { viewModel.updateNombre(it) },
                    label = { Text("Nombre") },
                    placeholder = { Text("Introduce tu nombre") },
                    trailingIcon = {
                        // Boton para reiniciar el campo
                        IconButton(onClick = { viewModel.updateNombre("") }) {
                            Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                        }
                    }
                )

                // TextField para el apellido
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.apellidos.value,
                    onValueChange = { viewModel.updateApellidos(it) },
                    label = { Text("Apellidos") },
                    placeholder = { Text("Introduce tus apellidos") },
                    trailingIcon = {
                        // Boton para reiniciar el campo
                        IconButton(onClick = { viewModel.updateApellidos("") }) {
                            Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                        }
                    }
                )

                // TextField para la edad
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.edad.value.toString(),
                    // Pongo el tipo de dato para que no se puedan introducir letras
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onValueChange = {
                        viewModel.updateEdad(
                            it.toIntOrNull() ?: viewModel.edad.value
                        )
                    },
                    label = { Text("Edad") },
                    trailingIcon = {
                        // Boton para borrar el campo a 0
                        IconButton(onClick = { viewModel.updateEdad(0) }) {
                            Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                        }
                    }
                )

                //TextField para el telefono
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.telefono.value.toString(),
                    // Pongo el tipo de dato para que no se puedan introducir letras
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    onValueChange = {
                        viewModel.updateTelefono(
                            it.toIntOrNull() ?: viewModel.telefono.value
                        )
                    },
                    label = { Text("Teléfono") },
                    trailingIcon = {
                        // Boton para borrar el campo a 0
                        IconButton(onClick = { viewModel.updateTelefono(0) }) {
                            Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                        }
                    }
                )

            }

            // Boton para ir a la segunda pantalla
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                // Voy a cambiiar e color del boton
                colors = ButtonColors(
                    containerColor = colorBoton,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Black
                ),
                onClick = {
                    //Comprobamos que todos los campos esten rellenos
                    if (viewModel.nombre.value.isEmpty() || viewModel.apellidos.value.isEmpty() || viewModel.edad.value == 0 || viewModel.telefono.value == 0) {
                        Toast.makeText(context, "Rellene todos los campos", Toast.LENGTH_SHORT)
                            .show()
                    }
                    // No compruebo que la edad sea negativa porque al introducirla directamente no deja poner negativa
                    // y si no estan vacios guardamos los datos en el viewModel y pasamos a la siguiente pantalla
                    else {
                        Toast.makeText(context, "Datos guardados correctamente", Toast.LENGTH_SHORT)
                            .show()
                        viewModel.updateUsuario(
                            Usuario(
                                viewModel.nombre.value,
                                viewModel.apellidos.value,
                                viewModel.edad.value,
                                viewModel.telefono.value
                            )
                        )

                        //Si todo va bien nos lleva a la segunda pantalla
                        navController.navigate("SecondScreen")

                    }
                }
            )
            {
                Text("Siguiente")
            }

        }
    }
}