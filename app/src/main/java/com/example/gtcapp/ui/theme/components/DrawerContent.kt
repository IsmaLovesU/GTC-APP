package com.example.gtcapp.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Support
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gtcapp.navigation.Screen
import com.example.gtcapp.ui.theme.GTCBlue
import com.example.gtcapp.ui.theme.GTCRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerContent(
    navController: NavController,
    onCloseDrawer: () -> Unit
) {
    ModalDrawerSheet(
        modifier = Modifier.width(300.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(GTCBlue)
                .padding(16.dp)
        ) {
            // Header del drawer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(GTCRed, RoundedCornerShape(6.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "G",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "GTCAPP",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                IconButton(
                    onClick = onCloseDrawer,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Cerrar menú"
                    )
                }
            }

            // Opciones del menú
            DrawerMenuItem(
                icon = Icons.Default.Home,
                title = "Inicio",
                onClick = {
                    navController.navigate(Screen.Home.route)
                    onCloseDrawer()
                }
            )

            DrawerMenuItem(
                icon = Icons.Default.Build,
                title = "Servicios",
                onClick = {
                    navController.navigate(Screen.Servicios.route)
                    onCloseDrawer()
                }
            )

            DrawerMenuItem(
                icon = Icons.Default.Assignment,
                title = "Solicitud de productos",
                onClick = {
                    // Navegar a solicitud de productos
                    onCloseDrawer()
                }
            )

            DrawerMenuItem(
                icon = Icons.Default.Settings,
                title = "Gestiones",
                onClick = {
                    navController.navigate(Screen.Gestiones.route)
                    onCloseDrawer()
                }
            )

            DrawerMenuItem(
                icon = Icons.Default.Support,
                title = "Atención Virtual",
                onClick = {
                    // Navegar a atención virtual
                    onCloseDrawer()
                }
            )

            Spacer(modifier = Modifier.weight(1f))

            // Footer del drawer con iconos
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(
                    onClick = { },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text("💬", fontSize = 20.sp)
                }

                IconButton(
                    onClick = { },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text("📍", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
private fun DrawerMenuItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}