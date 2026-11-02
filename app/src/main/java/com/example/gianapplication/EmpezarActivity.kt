
package com.example.gianapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gianapplication.screens.AgendarCitaScreen
import com.example.gianapplication.screens.BuscarMedicoScreen
import com.example.gianapplication.screens.MisCitasScreen
import com.example.gianapplication.ui.theme.BluePrimary
import com.example.gianapplication.ui.theme.GianApplicationTheme
import com.example.gianapplication.ui.theme.PinkAccent

class EmpezarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GianApplicationTheme {
                EmpezarScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmpezarScreen() {

    var buscarMedico by remember { mutableStateOf(false) }
    var agendarCita by remember { mutableStateOf(false) }
    var misCitas by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = if (buscarMedico) "Choose a doctor" else "Home",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(start = 12.dp)
                            .size(28.dp)
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BluePrimary
                )
            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = BluePrimary
            ) {
                NavigationBarItem(
                    selected = !buscarMedico,
                    onClick = { buscarMedico = false },
                    icon = {
                        Icon(
                            Icons.Filled.Home,
                            contentDescription = null
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = PinkAccent,
                        indicatorColor = BluePrimary
                    )
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            Icons.Outlined.MailOutline,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            Icons.Outlined.Info,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            Icons.Outlined.Call,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            Icons.Outlined.ShoppingCart,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                )
            }
        }
    ) { innerPadding ->

        if (buscarMedico || agendarCita || misCitas) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFEBEFF5))
            ) {
                TextButton(
                    onClick = { buscarMedico = false }
                ) {
                    TextButton(
                        onClick = {
                            buscarMedico = false
                            agendarCita = false
                            misCitas = false
                        }
                    ) {
                        Text("← Volver al Home")
                    }
                }

                if (buscarMedico) {
                    BuscarMedicoScreen()
                } else if (agendarCita) {
                    AgendarCitaScreen()
                } else if (misCitas) {
                    MisCitasScreen()
                }
            }

        } else {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0xFFEBEFF5))
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                ItemMaquetacion(
                    text = "Find a location",
                    icon = Icons.Default.LocationOn,
                    bgColor = Color(0xFF8AA9E8)
                )

                ItemMaquetacion(
                    text = "Choose a doctor",
                    icon = Icons.Default.Person,
                    bgColor = Color(0xFF5B82CA),
                    onClick = { buscarMedico = true }
                )

                ItemMaquetacion(
                    text = "Make an appointment",
                    icon = Icons.Default.Add,
                    bgColor = Color(0xFF4C70C0),
                    onClick = { agendarCita = true }
                )

                ItemMaquetacion(
                    text = "ER waiting period",
                    icon = Icons.Default.DateRange,
                    bgColor = Color(0xFF3B5FA8),
                    onClick = { misCitas = true }
                )

                ItemMaquetacion(
                    text = "Find an urgent care location",
                    icon = Icons.Default.LocationOn,
                    bgColor = PinkAccent
                )
            }
        }
    }
}

@Composable
fun ItemMaquetacion(
    text: String,
    icon: ImageVector,
    bgColor: Color,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .clickable { onClick() }
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = text,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmpezarScreenPreview() {
    GianApplicationTheme {
        EmpezarScreen()
    }
}
