package com.example.gtcapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gtcapp.navigation.Screen
import com.example.gtcapp.ui.theme.GTCBlue
import com.example.gtcapp.ui.theme.GTCRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberUser by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo y título
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 48.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(GTCRed, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "G",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "GTCAPP",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = GTCBlue
            )
        }

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible)
                            Icons.Default.VisibilityOff
                        else
                            Icons.Default.Visibility,
                        contentDescription = if (passwordVisible)
                            "Ocultar contraseña"
                        else
                            "Mostrar contraseña"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        // Recordar usuario
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = rememberUser,
                onCheckedChange = { rememberUser = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = GTCBlue,
                    checkedTrackColor = GTCBlue.copy(alpha = 0.3f)
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Recordar usuario",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = { /* Acción de olvidar contraseña */ }) {
                Text(
                    text = "¿Olvidaste tu\ncontraseña?",
                    fontSize = 12.sp,
                    color = GTCBlue,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de ingresar
        Button(
            onClick = {
                // Navegar al Home
                navController.navigate(Screen.Home.route) {
                    // Limpiar el stack de navegación para que no pueda volver al login
                    popUpTo(Screen.Login.route) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GTCBlue
            ),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "Ingresar",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Texto alternativo
        Text(
            text = "También puedes ingresar",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Iconos adicionales (placeholders)
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            repeat(3) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Gray.copy(alpha = 0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.Gray.copy(alpha = 0.3f))
                    )
                }
            }
        }
    }
}