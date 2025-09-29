package com.example.gtcapp.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Pagos : Screen("pagos")
    object Transferencia : Screen("transferencia")
    object Servicios : Screen("servicios")
    object Gestiones : Screen("gestiones")
    object Gastos : Screen("gastos")
    object Ahorros : Screen("ahorros")
}