package com.example.gianapplication.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.gianapplication.components.BotonPersonalizado
import com.example.gianapplication.components.TextFieldPersonalizado

@Composable
fun AgendarCitaScreen() {

    var medico by remember { mutableStateOf("") }
    var fecha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = "Agendar cita",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF244579)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextFieldPersonalizado(
            valor = medico,
            alCambiar = { medico = it },
            etiqueta = "Nombre del médico"
        )

        TextFieldPersonalizado(
            valor = fecha,
            alCambiar = { fecha = it },
            etiqueta = "Fecha de la cita"
        )

        Spacer(modifier = Modifier.height(16.dp))

        BotonPersonalizado(
            texto = "Agendar",
            alHacerClick = {

            }
        )
    }
}
