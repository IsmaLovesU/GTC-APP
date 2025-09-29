package com.example.gtcapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gtcapp.ui.theme.screens.GestionesScreen
import com.example.gtcapp.ui.theme.screens.HomeScreen
import com.example.gtcapp.ui.theme.screens.LoginScreen
import com.example.gtcapp.ui.theme.screens.PagosScreen
import com.example.gtcapp.ui.theme.screens.ServiciosScreen
import com.example.gtcapp.ui.theme.screens.TransferenciaScreen

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Pagos.route) {
            PagosScreen(navController = navController)
        }

        composable(Screen.Transferencia.route) {
            TransferenciaScreen(navController = navController)
        }

        composable(Screen.Servicios.route) {
            ServiciosScreen(navController = navController)
        }

        composable(Screen.Gestiones.route) {
            GestionesScreen(navController = navController)
        }
    }
}