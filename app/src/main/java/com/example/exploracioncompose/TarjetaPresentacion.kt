package com.example.exploracioncompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
private fun DatoContacto(icono: ImageVector, dato: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icono, contentDescription = null, tint = color)
        Spacer(Modifier.width(24.dp))
        Text(dato, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun VistaTarjeta() { TarjetaPresentacion() }
