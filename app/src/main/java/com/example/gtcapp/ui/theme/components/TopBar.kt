package com.example.gtcapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gtcapp.ui.theme.GTCBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    showBackButton: Boolean = false,
    onMenuClick: (() -> Unit)? = null,
    onBackClick: (() -> Unit)? = null
) {
    Column {
        // Barra superior con iconos
        TopAppBar(
            title = { },
            navigationIcon = {
                if (showBackButton && onBackClick != null) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                } else if (onMenuClick != null) {
                    IconButton(onClick = onMenuClick) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú",
                            tint = Color.White
                        )
                    }
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = "Actualizar",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Gray.copy(alpha = 0.3f)
            )
        )

        // Barra azul con información
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GTCBlue)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "📅 22-9-2025 🕐 4:44 p.m. | Compra $ | Q 7.48 | Venta $ | Q 7.80",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        // Título de la sección
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GTCBlue)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}