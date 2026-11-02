package com.example.gianapplication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gianapplication.ui.theme.BluePrimary

@Composable
fun TextFieldPersonalizado(
    valor: String,
    alCambiar: (String) -> Unit,
    etiqueta: String
) {
    OutlinedTextField(
        value = valor,
        onValueChange = alCambiar,
        label = {
            Text(
                text = etiqueta,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BluePrimary,
            unfocusedBorderColor = Color(0xFFB0BEC5),
            focusedLabelColor = BluePrimary,
            unfocusedLabelColor = Color(0xFF78909C),
            focusedTextColor = Color(0xFF263238),
            unfocusedTextColor = Color(0xFF263238),
            cursorColor = BluePrimary,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        )
    )
}