package com.example.focus_app

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.background
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Size

@Composable
fun PaginaPrincipal(nombreUsuario: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🔹 Encabezado con mensaje de bienvenida
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Tiempo de uso",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Bienvenido, $nombreUsuario ",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.End
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 Gráfico circular de uso (simulado)
        Canvas(modifier = Modifier.size(180.dp)) {
            drawArc(
                color = Color(0xFF4CAF50),
                startAngle = 0f,
                sweepAngle = 120f,
                useCenter = true,
                size = Size(size.width, size.height)
            )
            drawArc(
                color = Color(0xFFFFC107),
                startAngle = 120f,
                sweepAngle = 100f,
                useCenter = true,
                size = Size(size.width, size.height)
            )
            drawArc(
                color = Color(0xFFF44336),
                startAngle = 220f,
                sweepAngle = 140f,
                useCenter = true,
                size = Size(size.width, size.height)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 🔹 Botones de menú
        val botones = listOf("Objetivos", "Finanzas", "Calendario", "Hoy")
        botones.forEach { texto ->
            Button(
                onClick = { /* TODO: Navegar a la pantalla correspondiente */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = texto, fontSize = 18.sp, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 🔹 Botón grande de “Pedir más tiempo”
        Button(
            onClick = { /* TODO: Acción de pedir más tiempo */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9C27B0)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Pedir más tiempo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPaginaPrincipal() {
    PaginaPrincipal(nombreUsuario = "Andrés")
}
