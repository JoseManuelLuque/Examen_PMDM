package com.jluqgon214.examen_pmdp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jluqgon214.examen_pmdp.navigation.AppNavigation
import com.jluqgon214.examen_pmdp.ui.theme.Examen_PMDMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen_PMDMTheme {
                AppNavigation()
            }
        }
    }
}