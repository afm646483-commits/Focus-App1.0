package com.example.focus_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.focus_app.ui.theme.FocusAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FocusAppTheme {
                AppNavigator()
            }
        }
    }
}
@Composable
fun iniciarTransicion( ) {
   {
        // Espera 7 segundos en la pantalla Splash
        delay(7000)
        navController.navigate("frases") {
            popUpTo("splash") { inclusive = true }
        }

        // Espera 10 segundos en la pantalla de Frases
        delay(10000)
        navController.navigate("login") {
            popUpTo("frases") { inclusive = true }
        }

}

@Composable
fun AppNavigator() {
    var currentScreen by remember { mutableStateOf("main") }  // 👈 control de pantalla actual

    when (currentScreen) {
        "main" -> MainScreen(onEntrarClick = { currentScreen = "login" }) // 👈 cambia a login
        "login" -> PantallaLogin()
        "frases" -> FrasesScreen()
    }
}

@Composable
fun MainScreen(onEntrarClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.fa),
                contentDescription = "Logo Focus App",
                modifier = Modifier
                    .size(200.dp)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Focus App",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Button(
                onClick = onEntrarClick, // 👈 llama al cambio de pantalla
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(top = 8.dp)
            ) {
                Text("Entrar")
            }
        }
    }
}
