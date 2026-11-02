package com.example.gianapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MedicoCard(
    nombre: String,
    especialidad: String,
    telefono: String,
    correo: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            // Encabezado del médico
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .background(
                            color = Color(0xFFE3F2FD),
                            shape = RoundedCornerShape(16.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.LocalHospital,
                        contentDescription = "Médico",
                        tint = Color(0xFF1565C0),
                        modifier = Modifier.size(30.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = nombre,
                        fontSize = 19.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF17365D)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = especialidad,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF1976D2)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            HorizontalDivider(
                color = Color(0xFFE8EEF5),
                thickness = 1.dp
            )

            Spacer(modifier = Modifier.height(14.dp))

            // Teléfono
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Teléfono",
                    tint = Color(0xFF1976D2),
                    modifier = Modifier.size(21.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "Teléfono",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = telefono,
                        fontSize = 14.sp,
                        color = Color(0xFF424242)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Correo electrónico
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Correo electrónico",
                    tint = Color(0xFF1976D2),
                    modifier = Modifier.size(21.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = "Correo electrónico",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Text(
                        text = correo,
                        fontSize = 14.sp,
                        color = Color(0xFF424242)
                    )
                }
            }
        }
    }
}
