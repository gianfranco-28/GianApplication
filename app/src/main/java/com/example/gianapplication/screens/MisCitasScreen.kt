package com.example.gianapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gianapplication.components.CitaCard

data class Cita(
    val medico: String,
    val especialidad: String,
    val fecha: String
)

@Composable
fun MisCitasScreen() {

    val citas = listOf(
        Cita(
            medico = "Dra. Ana Torres",
            especialidad = "Cardiología",
            fecha = "20/11/2026"
        ),
        Cita(
            medico = "Dr. Luis Pérez",
            especialidad = "Pediatría",
            fecha = "25/11/2026"
        ),
        Cita(
            medico = "Dra. María López",
            especialidad = "Dermatología",
            fecha = "29/11/2026"
        )

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F7FC))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "Mis citas",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF244579)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Consulta las fechas de tus próximas atenciones.",
            fontSize = 14.sp,
            color = Color(0xFF757575)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // Contador de citas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFE3EEFF),
                    RoundedCornerShape(14.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = "Tienes ${citas.size} citas registradas",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF244579)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Próximas atenciones",
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF244579)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Mostrar las citas
        citas.forEach { cita ->

            CitaCard(
                medico = cita.medico,
                especialidad = cita.especialidad,
                fecha = cita.fecha
            )

            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}
