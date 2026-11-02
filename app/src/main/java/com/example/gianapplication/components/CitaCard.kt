package com.example.gianapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CitaCard(
    medico: String,
    especialidad: String,
    fecha: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            // Encabezado
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            Color(0xFFE3EEFF),
                            RoundedCornerShape(14.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "Cita médica",
                        tint = Color(0xFF244579),
                        modifier = Modifier.size(28.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = medico,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF244579)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = especialidad,
                        fontSize = 14.sp,
                        color = Color(0xFF757575)
                    )
                }

                // Estado visual
                Box(
                    modifier = Modifier
                        .background(
                            Color(0xFFE1F5E8),
                            RoundedCornerShape(8.dp)
                        )
                        .padding(
                            horizontal = 9.dp,
                            vertical = 6.dp
                        )
                ) {
                    Text(
                        text = "Programada",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF237A45)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            HorizontalDivider(
                color = Color(0xFFE8EEF5)
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Fecha de la cita
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "Fecha",
                    tint = Color(0xFF1976D2),
                    modifier = Modifier.size(22.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = "Fecha de atención",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = fecha,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF424242)
                    )
                }
            }
        }
    }
}
