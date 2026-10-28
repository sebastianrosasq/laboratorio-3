package com.example.exploracioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = true
        val pantalla = intent.getStringExtra("pantalla") ?: "fila"
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    when (pantalla) {
                        "simple" -> GreetingCard(etapa = 0)
                        "imagen" -> GreetingCard(etapa = 1)
                        "boton" -> GreetingCard(etapa = 2)
                        "tarjeta" -> TarjetaPresentacion()
                        else -> GreetingCard(etapa = 3)
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingCard(etapa: Int = 3) {
    var nombre by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("Hola Sebastian!") }
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = if (etapa == 3) Arrangement.Center else Arrangement.Top
    ) {
        Text("Bienvenido al curso!", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))
        Text(mensaje, fontSize = 20.sp)
        if (etapa == 1 || etapa == 2) {
            Spacer(Modifier.height(16.dp))
            TextField(value = nombre, onValueChange = { nombre = it }, label = { Text("Escribe tu nombre") })
        }
        if (etapa == 2) {
            Spacer(Modifier.height(16.dp))
            Button(onClick = { mensaje = if (nombre.isBlank()) "Hola estudiante!" else "Hola $nombre!" },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF006C93)),
                modifier = Modifier.width(180.dp)) { Text("Mostrar saludo", fontSize = 16.sp) }
        }
        if (etapa == 3) {
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Button(onClick = { mensaje = "Bienvenido al curso!" }) { Text("Aceptar") }
                Button(onClick = { mensaje = "Hola Sebastian!" }) { Text("Rechazar") }
            }
        }
        if (etapa > 0) {
            Spacer(Modifier.height(16.dp))
            Image(painterResource(R.drawable.tecsup), contentDescription = "Logo Tecsup", modifier = Modifier.size(150.dp))
        }
    }
}

@Composable
fun TarjetaPresentacion() {
    val verde = Color(0xFF006D3B)
    Box(Modifier.fillMaxSize().background(Color(0xFFD2E8D4))) {
        Column(Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painterResource(R.drawable.android_logo), contentDescription = "Android", modifier = Modifier.size(110.dp))
            Text("Jennifer Doe", fontSize = 40.sp, color = Color(0xFF101D13))
            Text("Android Developer Extraordinaire", fontSize = 16.sp, color = verde, fontWeight = FontWeight.Bold)
        }
        Column(Modifier.align(Alignment.BottomCenter).padding(bottom = 50.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            DatoContacto(Icons.Filled.Call, "+11 (123) 444 555 666", verde)
            DatoContacto(Icons.Filled.Share, "@AndroidDev", verde)
            DatoContacto(Icons.Filled.Email, "jen.doe@android.com", verde)
        }
    }
}

@Composable
fun DatoContacto(icono: androidx.compose.ui.graphics.vector.ImageVector, dato: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icono, contentDescription = null, tint = color)
        Spacer(Modifier.width(24.dp))
        Text(dato, fontSize = 16.sp)
    }
}

@Preview(showBackground = true) @Composable fun VistaSimple() { GreetingCard(0) }
@Preview(showBackground = true) @Composable fun VistaImagen() { GreetingCard(1) }
@Preview(showBackground = true) @Composable fun VistaBoton() { GreetingCard(2) }
@Preview(showBackground = true) @Composable fun VistaFila() { GreetingCard(3) }
@Preview(showBackground = true) @Composable fun VistaTarjeta() { TarjetaPresentacion() }
