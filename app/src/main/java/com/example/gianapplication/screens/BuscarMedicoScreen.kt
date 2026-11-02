package com.example.gianapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gianapplication.components.MedicoCard
import com.example.gianapplication.components.TextFieldPersonalizado

data class Medico(
    val nombre: String,
    val especialidad: String,
    val telefono: String,
    val correo: String
)

@Composable
fun BuscarMedicoScreen() {

    var busqueda by remember { mutableStateOf("") }

    val medicos = listOf(
        Medico(
            "Dra. Ana Torres",
            "Cardiología",
            "987654321",
            "anatorres@gmail.com"
        ),
        Medico(
            "Dr. Luis Pérez",
            "Pediatría",
            "945612387",
            "luisperez@gmail.com"
        ),
        Medico(
            "Dra. María López",
            "Dermatología",
            "963852741",
            "marialopez@gmail.com"
        )
    )

    val resultados = medicos.filter {
        it.nombre.contains(busqueda, ignoreCase = true) ||
                it.especialidad.contains(busqueda, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            text = "Buscar médico",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF244579)
        )

        TextFieldPersonalizado(
            valor = busqueda,
            alCambiar = { busqueda = it },
            etiqueta = "Nombre o especialidad"
        )

        if (resultados.isEmpty()) {

            Text(
                text = "No se encontraron médicos.",
                color = Color.Gray
            )

        } else {

            resultados.forEach { medico ->

                MedicoCard(
                    nombre = medico.nombre,
                    especialidad = medico.especialidad,
                    telefono = medico.telefono,
                    correo = medico.correo
                )
            }
        }
    }
}
