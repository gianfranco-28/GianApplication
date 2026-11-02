package com.example.gianapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gianapplication.components.BotonPersonalizado
import com.example.gianapplication.ui.theme.BlueLight
import com.example.gianapplication.ui.theme.BluePrimary
import com.example.gianapplication.ui.theme.GianApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GianApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background ) {
                    MainScreen(
                        onStartClick ={
                            startActivity(Intent(this@MainActivity, EmpezarActivity:: class.java))
                        },
                        onStartClick2 ={
                            startActivity(Intent(this@MainActivity, DoctoresActivity:: class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    onStartClick: () -> Unit,
    onStartClick2: () -> Unit
) {

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            BluePrimary,
            BlueLight,
            BluePrimary
        )
    )
    Column(
        modifier = Modifier.fillMaxSize()
            .background(brush = gradientBackground)
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

            Image(
                painter = painterResource(R.drawable.logo_corazon),
                contentDescription = stringResource(R.string.logo_name),
                modifier = Modifier.size(300.dp)
            )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            stringResource(R.string.logo_name),
            style = TextStyle( fontSize = 32.sp, fontWeight = FontWeight.Bold,
                color = Color.White, textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            stringResource(R.string.frase1),
            style = TextStyle( fontSize = 16.sp, fontWeight = FontWeight.Bold,
                color = Color.White, textAlign = TextAlign.Center, lineHeight = 22.sp
            )
        )
        Text(
            stringResource(R.string.frase2),
            style = TextStyle( fontSize = 16.sp, fontWeight = FontWeight.Bold,
                color = Color.White, textAlign = TextAlign.Center, lineHeight = 22.sp
        )
        )

        Spacer(modifier = Modifier.height(150.dp))

        BotonPersonalizado(
            texto = "Ingresar",
            alHacerClick = onStartClick
        )

        Spacer(modifier = Modifier.height(12.dp))

        BotonPersonalizado(
            texto = "Servicio Web",
            alHacerClick = onStartClick2
        )

    }
}