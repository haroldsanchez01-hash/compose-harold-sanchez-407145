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
import androidx.compose.runtime.getValue // Importar para la delegación 'by'
import androidx.compose.runtime.setValue // Importar para la delegación 'by'
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeactivity.ui.theme.ComposeActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeActivityTheme {
                // Llamamos a nuestro componente principal de la actividad 3.01
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Activity3_01Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/**
 * Componente principal para la implementación de la Sección 3.01: Contador Básico.
 */
@Composable
fun Activity3_01Screen(modifier: Modifier = Modifier) {
    // 1. Declaración de Estado: 'count' retendrá el valor y redibujará la UI al cambiar.
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 2. Mostrar el valor del Estado
        Text(
            text = "El contador es: $count",
            fontSize = 32.sp,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // 3. Botón para modificar el Estado
        Button(
            onClick = { count++ }, // Al hacer clic, incrementa el valor de 'count'
            // Deshabilita el botón si el contador llega a 10
            enabled = count < 10
        ) {
            Text("Incrementar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para resetear el contador (opcional)
        Button(
            onClick = { count = 0 },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text("Resetear")
        }
    }
}

// 4. Preview del componente de la actividad
@Preview(showBackground = true)
@Composable
fun Activity3_01Preview() {
    ComposeActivityTheme {
        Activity3_01Screen()
    }
}