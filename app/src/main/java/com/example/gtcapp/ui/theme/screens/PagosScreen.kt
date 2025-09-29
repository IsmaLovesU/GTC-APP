package com.example.gtcapp.ui.theme.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gtcapp.navigation.Screen
import com.example.gtcapp.ui.theme.components.DrawerContent
import com.example.gtcapp.ui.theme.components.GridCard
import com.example.gtcapp.ui.theme.components.TopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagosScreen(navController: NavController) {
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
                    title = "Pagos",
                    showBackButton = true,
                    onBackClick = {
                        navController.popBackStack()
                    },
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
                        selected = false,
                        onClick = { navController.navigate(Screen.Home.route) },
                        icon = { Text("🏠") },
                        label = { Text("Home") }
                    )
                    NavigationBarItem(
                        selected = true,
                        onClick = { },
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
                        title = "Cobro remesas",
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    )
                    GridCard(
                        title = "DeclaraGuate",
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
                        title = "Servicios",
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    )
                    GridCard(
                        title = "Préstamos",
                        modifier = Modifier.weight(1f),
                        onClick = { }
                    )
                }
            }
        }
    }
}

