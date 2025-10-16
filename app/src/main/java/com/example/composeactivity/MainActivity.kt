package com.example.composeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Scaffold
// Importa el Divider de Material3
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeActivityTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    // 1. Llamada al nuevo componente de la actividad 3.02
                    Activity3_02Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/**
 * Componente principal para la implementación de la Sección 3.02: Manejo de Listas.
 */
@Composable
fun Activity3_02Screen(modifier: Modifier = Modifier) {
    // Lista de datos de ejemplo
    val dataList = List(15) { "Elemento de la Lista #$it" }

    // LazyColumn es el equivalente de RecyclerView en Compose
    LazyColumn(modifier = modifier.fillMaxSize()) {
        // Itera sobre la lista de datos
        items(dataList) { item ->
            // Muestra cada elemento de la lista en un Text
            Text(text = item, modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
            HorizontalDivider(
                Modifier,
                DividerDefaults.Thickness,
                DividerDefaults.color
            ) // Separador visual entre elementos
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Activity3_02Preview() {
    ComposeActivityTheme {
        Activity3_02Screen()
    }
}