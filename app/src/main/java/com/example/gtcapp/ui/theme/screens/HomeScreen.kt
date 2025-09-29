package com.example.gtcapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gtcapp.navigation.Screen
import com.example.gtcapp.ui.theme.components.DrawerContent
import com.example.gtcapp.ui.theme.components.GridCard
import com.example.gtcapp.ui.theme.components.TopBar
import com.example.gtcapp.ui.theme.GTCBlue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                navController = navController,
                onCloseDrawer = {
                    scope.launch {
                        drawerState.close()
                    }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    title = "Gestiones",
                    onMenuClick = {
                        scope.launch {
                            drawerState.open()
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = { },
                        icon = { Text("🏠") },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate(Screen.Pagos.route) },
                        icon = { Text("💳") },
                        label = { Text("Pagos") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { navController.navigate(Screen.Transferencia.route) },
                        icon = { Text("↔️") },
                        label = { Text("Transferir") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { },
                        icon = { Text("💰") },
                        label = { Text("Gastos") }
                    )
                    NavigationBarItem(
                        selected = false,
                        onClick = { },
                        icon = { Text("🏦") },
                        label = { Text("Ahorros") }
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Primera fila
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    GridCard(
                        title = "Configuración de producto",
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    )
                    GridCard(
                        title = "Límite ATM y POS",
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    )
                }

                // Segunda fila
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    GridCard(
                        title = "Configuración de montos y servicios",
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    )
                    GridCard(
                        title = "Otros",
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    )
                }

                // Botones de navegación adicionales
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = { navController.navigate(Screen.Pagos.route) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = GTCBlue)
                    ) {
                        Text("Ir a Pagos", color = Color.White)
                    }

                    Button(
                        onClick = { navController.navigate(Screen.Transferencia.route) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(containerColor = GTCBlue)
                    ) {
                        Text("Ir a Transferencias", color = Color.White)
                    }
                }
            }
        }
    }
}