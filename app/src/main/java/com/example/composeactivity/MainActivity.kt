package com.example.composeactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// Asegúrate de que esta línea es correcta según tu estructura:
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Se aplica el tema
            ComposeActivityTheme {
                // El Scaffold ocupa toda la pantalla
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // **Esta es la única llamada de contenido de la App: el contador.**
                    // El contador debe aparecer centrado.
                    Modifier.padding(innerPadding).Activity3_01Screen()
                }
            }
        }
    }
}

/**
 * Componente principal para el Contador Básico (Sección 3.01).
 * Usa remember y mutableStateOf para manejar el estado.
 */
@Composable
fun Modifier.Activity3_01Screen() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "El contador es: $count",
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Button(
            onClick = { count++ },
            enabled = count < 10
        ) {
            Text("Incrementar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { count = 0 },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text("Resetear")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Activity3_01Preview() {
    ComposeActivityTheme {
        Modifier.Activity3_01Screen()
    }
}